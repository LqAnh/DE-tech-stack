package com.anhlq.consumer;

import com.anhlq.common.AppConfigs;
import com.opencsv.bean.CsvToBeanBuilder;
import com.sun.tools.javac.util.List;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        ArrayList<Integer> listId = new ArrayList<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "my-app-readcsv");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of(AppConfigs.topicName));

        try {
            System.out.println("Reading topic");
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.value());
                    //get all id exist in csv output file
                    try{
                        //String file = "data/output.csv";
                        java.util.List<Customer> beans1 = new CsvToBeanBuilder(new FileReader(AppConfigs.outputFile)).withType(Customer.class).build().parse();
                        for (Customer c:beans1){
                            listId.add(c.getId());
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    //check orderNum and age and id exist
                    java.util.List<Customer> beans = new CsvToBeanBuilder(new StringReader(record.value())).withType(Customer.class).build().parse();
                    for (Customer c : beans) {
                        if (!listId.contains(c.getId()) && c.getAge() < 20 && c.getNumOrder()>100 ){
                            File file1 = new File(AppConfigs.outputFile);
                            try {
                                // create FileWriter to write to output file
                                FileWriter pw = new FileWriter(file1, true);

                                pw.append(String.valueOf(c.getId())).append(",");
                                pw.append(String.valueOf(c.getNumOrder())).append(",");
                                pw.append(String.valueOf(c.getAge())).append(",");
                                pw.append(c.getPhoneNum());
                                pw.append("\n");

                                pw.flush();
                                pw.close();
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        } finally {
            consumer.close();
        }
    }


}
