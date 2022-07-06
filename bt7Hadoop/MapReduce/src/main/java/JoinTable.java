import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.Objects;

public class JoinTable {
    public static class JoinGroupingComparator extends WritableComparator {
        public JoinGroupingComparator() {
            super(JobKey.class, true);
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            JobKey first = (JobKey) a;
            JobKey second = (JobKey) b;

            return first.job.compareTo(second.job);
        }
    }

    public static class JoinSortingComparator extends WritableComparator {
        public JoinSortingComparator() {
            super(JobKey.class, true);
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b) {
            JobKey first = (JobKey) a;
            JobKey second = (JobKey) b;

            return first.compareTo(second);
        }
    }

    public static class PeopleMapper extends Mapper<LongWritable,
            Text, JobKey, JoinGenericWritable> {
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] recordFields = value.toString().split(",");

           if (!Objects.equals(recordFields[0] ,"id")) {

                int id = Integer.parseInt(recordFields[0]);
                String firstName = recordFields[1];
                String lastName = recordFields[2];
                String job = recordFields[8];
                int age = Integer.parseInt(recordFields[3]);

                JobKey jobKey = new JobKey(job, JobKey.PEOPLE_RECORD);
                PeopleRecord record = new PeopleRecord(id, firstName, lastName, age);

                JoinGenericWritable genericRecord = new JoinGenericWritable(record);
                context.write(jobKey, genericRecord);
            }
        }
    }

    public static class SalaryMapper extends Mapper<LongWritable,
            Text, JobKey, JoinGenericWritable> {
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] recordFields = value.toString().split(",");

            if (!Objects.equals(recordFields[0], "job")) {

                String job = recordFields[0];
                int salary = Integer.parseInt(recordFields[1]);

                JobKey jobKey = new JobKey(job, JobKey.SALARY_RECORD);
                SalaryRecord record = new SalaryRecord(salary);
                JoinGenericWritable genericRecord = new JoinGenericWritable(record);
                context.write(jobKey, genericRecord);
            }
        }
    }


    public static class JoinReducer extends Reducer<JobKey,
            JoinGenericWritable, NullWritable, Text> {

        @Override
        protected void setup(Reducer<JobKey, JoinGenericWritable, NullWritable, Text>.Context context) throws IOException, InterruptedException {
            context.write(NullWritable.get(),new Text("id,first_name,last_name,age,job,salary"));
        }

        public void reduce(JobKey key, Iterable<JoinGenericWritable> values,
                           Context context) throws IOException, InterruptedException {
            StringBuilder output = new StringBuilder();
            String salary = null;

            for (JoinGenericWritable v : values) {
                Writable record = v.get();
                if (key.recordType.equals(JobKey.SALARY_RECORD)) {
                    SalaryRecord record2 = (SalaryRecord) record;
                    salary = record2.salary.toString();

                } else {
                    PeopleRecord pRecord = (PeopleRecord) record;
                    output.append((pRecord.id.toString())).append(",");
                    output.append(pRecord.firstName.toString()).append(",");
                    output.append(pRecord.lastName.toString()).append(",");
                    output.append(pRecord.age.toString()).append(",");
                    output.append(key.job).append(",");
                    output.append(salary);
                    output.append("\n");
                }
            }
            context.write(NullWritable.get(), new Text(output.toString()));
        }
    }

    public static void main(String[] allArgs) throws Exception {
        Configuration conf = new Configuration();

        String[] args = new GenericOptionsParser(conf, allArgs).getRemainingArgs();


        Job job = Job.getInstance(conf);
        job.setJarByClass(JoinTable.class);


        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setMapOutputKeyClass(JobKey.class);
        job.setMapOutputValueClass(JoinGenericWritable.class);

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, SalaryMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, PeopleMapper.class);


        job.setReducerClass(JoinReducer.class);

        job.setSortComparatorClass(JoinSortingComparator.class);
        job.setGroupingComparatorClass(JoinGroupingComparator.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);
        FileOutputFormat.setOutputPath(job, new Path(allArgs[2]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

}
