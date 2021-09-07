package com.mycompany.jsonconsumerservice.kafka.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class News {

    private String id;
    private Integer fromId;
    private String fromName;
    private String title;
}
