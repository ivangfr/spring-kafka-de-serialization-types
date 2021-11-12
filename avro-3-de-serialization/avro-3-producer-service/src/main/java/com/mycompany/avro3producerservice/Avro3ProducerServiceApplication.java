package com.mycompany.avro3producerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;

@NativeHint(options = "--enable-url-protocols=http")
@SpringBootApplication
public class Avro3ProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Avro3ProducerServiceApplication.class, args);
    }
}
