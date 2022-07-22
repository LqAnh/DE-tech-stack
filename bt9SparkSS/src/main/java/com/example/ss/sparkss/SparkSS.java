package com.example.ss.sparkss;


import com.example.ss.protos.DataTracking;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class SparkSS {
    public static void main(String[] args) throws StreamingQueryException, TimeoutException {
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark Streaming with Kafka")
                .config("spark.dynamicAllocation.enabled", "false")
                .getOrCreate();
        spark.sparkContext().setLogLevel("ERROR");
        ReadStream(spark);

    }

    private static void ReadStream(SparkSession spark) throws StreamingQueryException, TimeoutException {

        final String BOOSTRAP_SERVER = "172.17.80.26:9092";
        final String TOPIC = "data_tracking_anhlq36m";

        Dataset<Row> df = spark
                .readStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", BOOSTRAP_SERVER)
                .option("subscribe", TOPIC)
                .option("startingOffsets", "earliest")
                .load();

        Dataset<byte[]> df1 = df.select("value").as(Encoders.BINARY());

        Dataset<String> df2 = df1.map((MapFunction<byte[], String>)
                        value -> DataTracking.parseFrom(value).getVersion() + "," +
                                DataTracking.parseFrom(value).getName() + "," +
                                DataTracking.parseFrom(value).getTimestamp() + "," +
                                DataTracking.parseFrom(value).getPhoneId() + "," +
                                DataTracking.parseFrom(value).getLon() + "," +
                                DataTracking.parseFrom(value).getLat() + "," +

                                (getTime(DataTracking.parseFrom(value).getTimestamp()).getYear() + 1900) + "," +
                                (getTime(DataTracking.parseFrom(value).getTimestamp()).getDate()) + "," +
                                (getTime(DataTracking.parseFrom(value).getTimestamp()).getHours())
                , Encoders.STRING());

        Dataset<Row> df3 = df2.withColumn("version", functions.split(df2.col("value"), ",").getItem(0))
                .withColumn("name", functions.split(df2.col("value"), ",").getItem(1))
                .withColumn("timestamp", functions.split(df2.col("value"), ",").getItem(2))
                .withColumn("phone_id", functions.split(df2.col("value"), ",").getItem(3))
                .withColumn("lon", functions.split(df2.col("value"), ",").getItem(4))
                .withColumn("lat", functions.split(df2.col("value"), ",").getItem(5))
                .withColumn("year", functions.split(df2.col("value"), ",").getItem(6))
                .withColumn("day", functions.split(df2.col("value"), ",").getItem(7))
                .withColumn("hour", functions.split(df2.col("value"), ",").getItem(8))
                .drop("value");

        StreamingQuery query = df3
                .writeStream()
                .outputMode("append")
                .format("parquet")
                .option("compression", "snappy")
                .option("checkpointLocation", "hdfs://172.17.80.21:9000/user/anhlq36/checkpoint")
                .option("path", "hdfs://172.17.80.21:9000/user/anhlq36/data_tracking")
                .partitionBy("year", "day", "hour")
                .start();

        query.awaitTermination();
    }

    private static Date getTime(long input) {
        String np = String.valueOf(input);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyddHH");
        Date formatdate;
        try {
            formatdate = sdf.parse(np);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return formatdate;
    }
}
