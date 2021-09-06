package com.mycompany.avro3producerservice.kafka.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class News {

    String id;
    Integer fromId;
    String fromName;
    String title;
}
