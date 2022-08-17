package com.ivanfranchin.avro2producerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
