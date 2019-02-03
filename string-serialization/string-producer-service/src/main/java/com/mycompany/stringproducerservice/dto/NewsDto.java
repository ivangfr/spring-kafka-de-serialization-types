package com.mycompany.stringproducerservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class NewsDto {

    @Positive
    private Integer fromId;

    @NotBlank
    private String fromName;

    @NotBlank
    private String title;

}
