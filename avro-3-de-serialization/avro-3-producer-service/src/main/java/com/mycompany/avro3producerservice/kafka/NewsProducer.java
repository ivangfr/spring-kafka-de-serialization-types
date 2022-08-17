package com.mycompany.avro3producerservice.kafka;

import com.mycompany.avro3producerservice.avro.NewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsProducer {

    private static final Logger log = LoggerFactory.getLogger(NewsProducer.class);

    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public NewsProducer(KafkaTemplate<String, NewsMessage> kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProperties = kafkaProperties;
    }

    public void send(NewsMessage newsMessage) {
        String kafkaTopic = kafkaProperties.getProducer().getProperties().get("topic");
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, String.valueOf(newsMessage.getFromId()), newsMessage);
    }
}
