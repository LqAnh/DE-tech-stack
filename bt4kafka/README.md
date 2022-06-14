Some important config in AppConfigs class: 
    --bootstrap-server 172.17.80.20:9092
    topic name: customer_anhlq36

Workflow:
    Producer: Read csv file, send each line read. 
    Consumer: An infinity loop. 
              Add all id in output file into an arraylist. 
              Read each record in topic, check all the condition (age, orderNum, id not duplicate) then write to output file.


