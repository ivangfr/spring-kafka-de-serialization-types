package com.ivanfranchin.avroproducerservice.kafka;

import com.ivanfranchin.avroproducerservice.avro.NewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsProducer {

    private static final Logger log = LoggerFactory.getLogger(NewsProducer.class);

    private final KafkaProperties kafkaProperties;
    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;

    public NewsProducer(KafkaProperties kafkaProperties, KafkaTemplate<String, NewsMessage> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(NewsMessage newsMessage) {
        String kafkaTopic = kafkaProperties.getProducer().getProperties().get("topic");
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, String.valueOf(newsMessage.getFromId()), newsMessage);
    }
}
