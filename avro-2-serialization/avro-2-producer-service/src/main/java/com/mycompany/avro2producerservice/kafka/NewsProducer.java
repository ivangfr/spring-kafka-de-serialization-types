package com.mycompany.avro2producerservice.kafka;

import com.mycompany.commons.avroserialization.avro.NewsMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NewsProducer {

    private final KafkaTemplate<String, NewsMessage> kafkaTemplate;

    public NewsProducer(KafkaTemplate<String, NewsMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.producer.topic}")
    private String kafkaTopic;

    public void send(NewsMessage newsMessage) {
        log.info("Sending News '{}' to topic '{}'", newsMessage, kafkaTopic);
        kafkaTemplate.send(kafkaTopic, newsMessage.getFromId().toString(), newsMessage);
    }

}
