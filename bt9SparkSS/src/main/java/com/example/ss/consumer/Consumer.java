package com.example.ss.consumer;

import com.example.ss.protos.DataTracking;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        Consumer kafkaConsumer = new Consumer();
        kafkaConsumer.readMsg();
    }

    private void readMsg() throws InvalidProtocolBufferException {

        final String BOOSTRAP_SERVER = "172.17.80.26:9092";
        final String TOPIC = "data_tracking_anhlq36";

        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOSTRAP_SERVER);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        final org.apache.kafka.clients.consumer.Consumer<String, byte[]> consumer = new KafkaConsumer<String, byte[]>(props);
        consumer.subscribe(Arrays.asList(TOPIC));

        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records) {
                DataTracking dataTracking = DataTracking.parseFrom(record.value());
                System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), dataTracking);
            }
        }

    }
}
