package com.ivanfranchin.avro2producerservice.news;

public record News(String id, Integer fromId, String fromName, String title) {
}
