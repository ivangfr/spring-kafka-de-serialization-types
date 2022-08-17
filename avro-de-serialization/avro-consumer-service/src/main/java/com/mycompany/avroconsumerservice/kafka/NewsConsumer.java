package com.mycompany.avroconsumerservice.kafka;

import com.mycompany.avroconsumerservice.avro.NewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;

@Service
public class NewsConsumer {

    private static final Logger log = LoggerFactory.getLogger(NewsConsumer.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    //-- It's not working in native mode the @Header annotation to get the metadata
//    public void listen(@Payload NewsMessage newsMessage,
//                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
//                       @Header(KafkaHeaders.OFFSET) Long offset) {
    //--
    public void listen(@Payload NewsMessage newsMessage, ConsumerRecordMetadata metadata) {
        log.info("Received message\n---\nTOPIC: {}; PARTITION: {}; OFFSET: {};\nPAYLOAD: {}\n---",
                metadata.topic(), metadata.partition(), metadata.offset(), newsMessage);
    }
}
