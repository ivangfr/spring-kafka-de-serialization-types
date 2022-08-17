package com.mycompany.avroproducerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
