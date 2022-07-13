import org.apache.spark.sql.*;


public class SmallProcess {
    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .appName("Java Spark SQL with small file")
                .getOrCreate();
        ReadFile(spark);

        spark.stop();
    }

    private static void ReadFile(SparkSession spark) {

        Dataset<Row> smallFileDF = spark.read().parquet("/anhlq36/spark/input/small.snappy.parquet");
        smallFileDF.createOrReplaceTempView("parquet2");

        Dataset<Row> small = spark.sql("SELECT device_model, user_id, button_id  FROM parquet2 WHERE device_model IS NOT NULL");
        small.createOrReplaceTempView("small");

        Dataset<Row> small1 = spark.sql("SELECT device_model, COUNT(DISTINCT user_id) as count FROM small GROUP BY device_model");
        small1.repartition(1).write().mode("overwrite").format("parquet").save("/anhlq36/spark/outputsmall/output1");


        Dataset<Row> small2 = spark.sql("SELECT DISTINCT device_model, collect_set(user_id) AS list_user_id FROM small GROUP BY device_model");
        small2.repartition(1).write().mode("overwrite").format("orc").save("/anhlq36/spark/outputsmall/output2");


        Dataset<Row> small3 = spark.sql("SELECT CONCAT(user_id ,'_', device_model) AS user_id_device_model, button_id, COUNT(*) AS count FROM small WHERE button_id IS NOT NULL GROUP BY user_id_device_model, button_id");
        small3.repartition(1).write().mode("overwrite").format("parquet").save("/anhlq36/spark/outputsmall/output3");

    }
}
