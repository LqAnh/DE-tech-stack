import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PeopleRecord implements Writable {

    public IntWritable id = new IntWritable();
    public Text firstName = new Text();
    public Text lastName = new Text();

    public IntWritable age = new IntWritable();

    public PeopleRecord(){}

    public PeopleRecord(int id, String firstName, String lastName, int age) {
        this.id.set(id);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.age.set(age);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        this.id.write(out);
        this.firstName.write(out);
        this.lastName.write(out);
        this.age.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.id.readFields(in);
        this.firstName.readFields(in);
        this.lastName.readFields(in);
        this.age.readFields(in);
    }
}
