package com.mycompany.avroproducerservice.kafka;

import com.mycompany.avroproducerservice.avro.NewsMessage;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class NewsProducerConfig {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${kafka.producer.topic}")
    private String topic;

    @Value("${kafka.producer.num-partitions}")
    private Integer numPartitions;

    @Bean
    ProducerFactory<String, NewsMessage> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
        return props;
    }

    @Bean
    KafkaTemplate<String, NewsMessage> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // As the application will create a topic in Kafka, it is better to update the KafkaAdmin's BOOTSTRAP_SERVERS_CONFIG
    // property with the bootstrap servers' url configured, otherwise it will get the default 'localhost:9082'
    @Bean
    KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    @Bean
    NewTopic newTopic() {
        return new NewTopic(topic, numPartitions, (short) 1);
    }

}
