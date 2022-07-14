<<<<<<< HEAD
output path for big file in hdfs
    
    /user/anhlq36/big_file

output path for small file in hdfs
    
    /user/anhlq36/small_file

command to run inside folder /home/hadoop/anhlq36/spark
    small file:

        spark-submit --deploy-mode client  --class SmallProcess spark.jar
    
    big file:

        spark-submit --deploy-mode client  --class BigProcess spark.jar


=======
output path for result of big file in hdfs

    /user/anhlq36/big_file

output path for result of small file in hdfs

    /user/anhlq36/small_file
    
    
    
command to run


inside folder /home/hadoop/anhlq36/spark



small file:

        spark-submit --deploy-mode client  --class SmallProcess spark.jar
        
big file:

        spark-submit --deploy-mode client  --class BigProcess spark.jar
>>>>>>> 618efca4d9b634d0d001635b020063a76ef3e31a
