package com.mycompany.avro2producerservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Value("${kafka.producer.topic}")
    private String topic;

    @Value("${kafka.producer.num-partitions}")
    private Integer numPartitions;

    @Bean
    public NewTopic newTopic() {
        return new NewTopic(topic, numPartitions, (short) 1);
    }

}
