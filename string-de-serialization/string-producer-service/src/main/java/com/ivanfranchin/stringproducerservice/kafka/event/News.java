package com.ivanfranchin.stringproducerservice.kafka.event;

public record News(String id, Integer fromId, String fromName, String title) {

    @Override
    public String toString() {
        return String.format("id:%s;fromId:%s;fromName:%s;title:%s", id, fromId, fromName, title);
    }
}
