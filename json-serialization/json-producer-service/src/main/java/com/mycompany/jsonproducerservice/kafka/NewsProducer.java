package com.mycompany.jsonproducerservice.kafka;

import com.mycompany.jsonproducerservice.domain.News;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsProducer {

    private final KafkaTemplate<String, News> kafkaTemplate;

    @Value("${kafka.producer.topic}")
    private String kafkaTopic;

    public void send(News news) {
        log.info("Sending News '{}' to topic '{}'", news, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, news.getFromId().toString(), news);
    }

}
