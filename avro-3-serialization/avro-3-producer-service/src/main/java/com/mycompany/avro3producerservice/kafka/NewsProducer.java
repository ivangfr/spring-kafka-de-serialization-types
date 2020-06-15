package com.mycompany.avro3producerservice.kafka;

import com.mycompany.avro3producerservice.avro.NewsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewsProducer {

    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void send(NewsMessage newsMessage) {
        String kafkaTopic = kafkaProperties.getProducer().getProperties().get("topic");
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, String.valueOf(newsMessage.getFromId()), newsMessage);
    }

}
