output path for big file in hdfs
    
    /user/anhlq36/big_file

output path for small file in hdfs
    
    /user/anhlq36/small_file

command to run inside folder /home/hadoop/anhlq36/spark
    small file:

        spark-submit --deploy-mode client  --class SmallProcess spark.jar
    
    big file:

        spark-submit --deploy-mode client  --class BigProcess spark.jar


