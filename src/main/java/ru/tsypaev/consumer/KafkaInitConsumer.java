package ru.tsypaev.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

public class KafkaInitConsumer {
    private Properties consumerProperties = new Properties();

    public KafkaConsumer<String, String> getKafkaConsumer() {
        consumerProperties.put("bootstrap.servers", "localhost:9092");
        consumerProperties.put("group.id", "TestTopic");
        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        return new KafkaConsumer<>(consumerProperties);
    }

}
