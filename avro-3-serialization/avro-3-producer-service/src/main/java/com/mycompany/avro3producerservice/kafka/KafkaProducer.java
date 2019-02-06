package com.mycompany.avro3producerservice.kafka;

import com.mycompany.avro3producerservice.avro.NewsMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, NewsMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.producer.topic}")
    private String kafkaTopic;

    public void send(NewsMessage newsMessage) {
        log.info("Sending News with id '{}' to topic '{}'", newsMessage.getId(), kafkaTopic);
        kafkaTemplate.send(kafkaTopic, newsMessage.getFromId().toString(), newsMessage);
    }

}
