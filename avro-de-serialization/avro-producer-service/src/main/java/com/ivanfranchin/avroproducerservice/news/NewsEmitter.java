package com.ivanfranchin.avroproducerservice.news;

import com.ivanfranchin.avroproducerservice.avro.NewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsEmitter {

    private static final Logger log = LoggerFactory.getLogger(NewsEmitter.class);

    private final KafkaProperties kafkaProperties;
    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;

    public NewsEmitter(KafkaProperties kafkaProperties, KafkaTemplate<String, NewsMessage> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(NewsMessage newsMessage) {
        String kafkaTopic = kafkaProperties.getProducer().getProperties().get("topic");
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, newsMessage.getId().toString(), newsMessage);
    }
}
