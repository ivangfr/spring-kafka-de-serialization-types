package com.mycompany.jsonconsumerservice.kafka;

import com.mycompany.jsonconsumerservice.domain.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group-id}")
    public void listen(Message<News> message) {
        log.info("Received {}", message);
    }

}
