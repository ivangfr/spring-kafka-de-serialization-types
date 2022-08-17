package com.ivanfranchin.jsonproducerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
