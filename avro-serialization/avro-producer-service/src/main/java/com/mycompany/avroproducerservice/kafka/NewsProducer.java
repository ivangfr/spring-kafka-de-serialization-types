package com.mycompany.avroproducerservice.kafka;

import com.mycompany.avroproducerservice.avro.NewsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class NewsProducer {

    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;

    @Value("${kafka.producer.topic}")
    private String kafkaTopic;

    public void send(NewsMessage newsMessage) {
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, String.valueOf(newsMessage.getFromId()), newsMessage);
    }

}
