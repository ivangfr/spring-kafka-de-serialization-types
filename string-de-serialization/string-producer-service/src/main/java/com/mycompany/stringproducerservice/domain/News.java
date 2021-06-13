package com.mycompany.stringproducerservice.domain;

import lombok.Data;

@Data
public class News {

    private String id;
    private Integer fromId;
    private String fromName;
    private String title;

    @Override
    public String toString() {
        return String.format("id:%s;fromId:%s;fromName:%s;title:%s", id, fromId, fromName, title);
    }
}
