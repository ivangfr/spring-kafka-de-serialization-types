package com.mycompany.stringproducerservice.kafka.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class News {

    String id;
    Integer fromId;
    String fromName;
    String title;

    @Override
    public String toString() {
        return String.format("id:%s;fromId:%s;fromName:%s;title:%s", id, fromId, fromName, title);
    }
}
