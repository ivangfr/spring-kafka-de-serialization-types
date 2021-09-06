package com.mycompany.avroproducerservice.kafka.event;

import lombok.Value;

@Value(staticConstructor = "of")
public class News {

    String id;
    Integer fromId;
    String fromName;
    String title;
}
