package ru.tsypaev.producer;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class KafkaInitProducer {
    private Properties producerProperties = new Properties();

    public KafkaProducer<String, String> getKafkaProducer() {
        producerProperties.put("bootstrap.servers", "localhost:9092");
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new KafkaProducer<>(producerProperties);
    }

}
