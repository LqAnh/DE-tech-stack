import org.apache.spark.sql.*;

public class BigProcess {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Java Spark SQL with big file")
                .getOrCreate();
        ReadFile(spark);

        spark.stop();
    }

    private static void ReadFile(SparkSession spark) {
        Dataset<Row> bigFileDF = spark.read().parquet("/anhlq36/spark/input/big.snappy.parquet");
        bigFileDF.createOrReplaceTempView("parquet1");

        Dataset<Row> big = spark.sql("SELECT device_model, user_id, button_id FROM parquet1 WHERE device_model IS NOT NULL");
        big.createOrReplaceTempView("big");

        Dataset<Row> small1 = spark.sql("SELECT device_model, COUNT(DISTINCT user_id) as count FROM big GROUP BY device_model");
        small1.repartition(1).write().mode("overwrite").format("parquet").save("/anhlq36/spark/outputbig/output1");


        Dataset<Row> small2 = spark.sql("SELECT DISTINCT device_model, collect_set(user_id) AS list_user_id FROM big GROUP BY device_model");
        small2.repartition(1).write().mode("overwrite").format("orc").save("/anhlq36/spark/outputbig/output2");


        Dataset<Row> small3 = spark.sql("SELECT CONCAT(user_id ,'_', device_model) AS user_id_device_model, button_id, COUNT(*) AS count FROM big WHERE button_id IS NOT NULL GROUP BY user_id_device_model, button_id");
        small3.repartition(1).write().mode("overwrite").format("parquet").save("/anhlq36/spark/outputbig/output3");

    }
}
