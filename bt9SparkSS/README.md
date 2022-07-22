Các class trong package protos được compile bằng câu lệnh trong folder proto

Producer sinh dữ liệu đẩy lên kafka topic `data_tracking_anhlq36` trên server `172.17.80.26`

SparkSS đọc dữ liệu từ kafka source xử lý và lưu vào hdfs 

Checkpoint

    hdfs://172.17.80.21:9000/user/anhlq36/checkpoint
    
Output 

    hdfs://172.17.80.21:9000/user/anhlq36/data_tracking

Câu lệnh spark-submit: trên server `172.17.80.21` trong folder `/home/hadoop/anhlq36/sparkss`

    spark-submit --deploy-mode client --packages org.apache.spark:spark-sql-kafka-0-10_2.11:2.4.0,com.google.protobuf:protobuf-java:3.15.8 --class com.example.ss.sparkss.SparkSS bt9SparkSS-1.0-SNAPSHOT.jar