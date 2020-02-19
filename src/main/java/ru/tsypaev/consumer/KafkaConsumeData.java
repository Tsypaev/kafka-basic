package ru.tsypaev.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

public class KafkaConsumeData {
    public static void main(String[] args) {
        KafkaInitConsumer initConsumer = new KafkaInitConsumer();
        KafkaConsumer<String, String> consumer = initConsumer.getKafkaConsumer();

        consumer.subscribe(Collections.singletonList("TestTopic"));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("topic = " + record.topic());
                    System.out.println("partition = " + record.partition());
                    System.out.println("offset = " + record.offset());
                    System.out.println("key = " + record.key());
                    System.out.println("value = " + record.value());
                }
                consumer.commitAsync();
            }
        } finally {
            consumer.close();
        }
    }
}
