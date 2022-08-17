package com.ivanfranchin.jsonproducerservice.kafka;

import com.ivanfranchin.jsonproducerservice.kafka.event.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NewsProducer {

    private static final Logger log = LoggerFactory.getLogger(NewsProducer.class);

    private final KafkaTemplate<String, News> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public NewsProducer(KafkaTemplate<String, News> kafkaTemplate, KafkaProperties kafkaProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaProperties = kafkaProperties;
    }

    public void send(News news) {
        String kafkaTopic = kafkaProperties.getProducer().getProperties().get("topic");
        log.info("Sending News '{}' to topic '{}'", news, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, news.id(), news);
    }
}
