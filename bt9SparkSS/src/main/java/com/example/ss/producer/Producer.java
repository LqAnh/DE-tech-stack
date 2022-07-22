package com.example.ss.producer;

import com.example.ss.protos.DataTracking;
import com.github.javafaker.Faker;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Producer {
    public static void main(String[] args) throws InterruptedException {

        Producer producer = new Producer();
        producer.writeMsg();
    }

    private void writeMsg() throws InterruptedException {

        final String BOOSTRAP_SERVER = "172.17.80.26:9092";
        final String TOPIC = "data_tracking_anhlq36";

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOSTRAP_SERVER);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");

        for (int i = 1; i < 1001; i++) {
            org.apache.kafka.clients.producer.Producer<String, byte[]> producer = new KafkaProducer<>(properties);
            TimeUnit.SECONDS.sleep(500);

            Faker faker = new Faker(new Locale("en"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyddHH");

            String version = String.valueOf(faker.random().nextInt(1, 10));
            String name = faker.name().name();
            String timeStamp = sdf.format(faker.date().past(20, TimeUnit.DAYS));
            String phoneId = faker.idNumber().ssnValid();
            phoneId = phoneId.substring(0, phoneId.indexOf("-"));
            long longitude = faker.random().nextInt(1, 999);
            long latitude = faker.random().nextInt(1, 999);
            ;

            DataTracking.Builder builder = DataTracking.newBuilder();
            DataTracking dataTracking = builder
                    .setVersion(version)
                    .setName(name)
                    .setTimestamp(Long.parseLong(timeStamp))
                    .setPhoneId(phoneId)
                    .setLon(longitude)
                    .setLat(latitude)
                    .build();

            byte[] record = dataTracking.toByteArray();

            producer.send(new ProducerRecord<String, byte[]>(TOPIC, null, record));
            System.out.println(dataTracking);
            producer.flush();
            producer.close();
        }
    }

}
