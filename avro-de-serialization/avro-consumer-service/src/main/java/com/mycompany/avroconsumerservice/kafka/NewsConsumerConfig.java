package com.mycompany.avroconsumerservice.kafka;

import com.mycompany.avroconsumerservice.avro.NewsMessage;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Map;

@RequiredArgsConstructor
@EnableKafka
@Configuration
public class NewsConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    ConcurrentKafkaListenerContainerFactory<String, NewsMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NewsMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(kafkaProperties.getListener().getConcurrency());
        return factory;
    }

    ConsumerFactory<String, NewsMessage> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new AvroDeserializer<>(NewsMessage.class));
    }

    Map<String, Object> consumerConfigs() {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AvroDeserializer.class);
        props.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, false);
        return props;
    }
}
