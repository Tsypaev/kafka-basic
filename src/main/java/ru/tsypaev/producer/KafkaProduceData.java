package ru.tsypaev.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KafkaProduceData {
    public static void main(String[] args) {
        KafkaInitProducer initProducer = new KafkaInitProducer();
        KafkaProducer<String, String> producer = initProducer.getKafkaProducer();

        ProducerRecord<String, String> record =
                new ProducerRecord<>("TestTopic", "Key", "Value");

        RecordMetadata metadata;
        try {
            metadata = producer.send(record).get();
        } catch (Exception ex) {
            System.out.println("Ошибочка вышла!");
            return;
        }

        System.out.println(metadata.offset());
    }
}
