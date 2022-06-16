package com.anhlq.producer;

import com.anhlq.common.AppConfigs;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.*;
import java.util.Properties;

public class Producer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(AppConfigs.inputFile));
            reader.readLine();
            String line1 = null;
            while ((line1 = reader.readLine()) != null) {
                System.out.println(line1);
                producer.send(new ProducerRecord<>(AppConfigs.topicName, null, line1));
            }
            reader.close();
            producer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
