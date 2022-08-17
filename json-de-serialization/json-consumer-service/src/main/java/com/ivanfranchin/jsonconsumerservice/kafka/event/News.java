package com.ivanfranchin.jsonconsumerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
