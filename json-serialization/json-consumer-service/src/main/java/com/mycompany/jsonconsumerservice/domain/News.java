package com.mycompany.jsonconsumerservice.domain;

import lombok.Data;

@Data
public class News {

    private String id;
    private Integer fromId;
    private String fromName;
    private String title;

}
