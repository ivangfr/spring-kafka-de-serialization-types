package com.mycompany.avro3producerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
