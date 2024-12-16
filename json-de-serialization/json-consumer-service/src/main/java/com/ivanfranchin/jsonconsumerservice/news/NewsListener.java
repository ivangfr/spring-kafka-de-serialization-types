package com.ivanfranchin.jsonconsumerservice.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class NewsListener {

    private static final Logger log = LoggerFactory.getLogger(NewsListener.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload News news, ConsumerRecordMetadata metadata) {
        log.info("Received message\n---\nTOPIC: {}; PARTITION: {}; OFFSET: {};\nPAYLOAD: {}\n---",
                metadata.topic(), metadata.partition(), metadata.offset(), news);
    }
}
