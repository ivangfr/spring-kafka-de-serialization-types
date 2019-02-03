package com.mycompany.jsonproducerservice.kafka;

import com.mycompany.jsonproducerservice.domain.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, News> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, News> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.producer.topic}")
    private String kafkaTopic;

    public void send(News news) {
        log.info("Sending News with id '{}' to topic '{}'", news.getId(), kafkaTopic);
        kafkaTemplate.send(kafkaTopic, news.getFromId().toString(), news);
    }

}
