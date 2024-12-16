package com.ivanfranchin.avro3producerservice.news;

public record News(String id, Integer fromId, String fromName, String title) {
}
