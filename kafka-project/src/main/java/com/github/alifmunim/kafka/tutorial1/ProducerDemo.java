package com.github.alifmunim.kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;


import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {
        // Create producer properties
        Properties properties = new Properties();
        String bootstrapServers = "127.0.0.1:9092";
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // Create producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "hello world");

        // Send data (async)
        producer.send(record);

        // Flush and close producer
        producer.flush();
        producer.close();
    }
}
