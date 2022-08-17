package com.mycompany.jsonconsumerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {
}
