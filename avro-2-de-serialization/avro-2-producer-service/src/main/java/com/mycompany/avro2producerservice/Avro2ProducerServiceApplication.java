package com.mycompany.avro2producerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;

@NativeHint(options = "--enable-url-protocols=http")
@SpringBootApplication
public class Avro2ProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Avro2ProducerServiceApplication.class, args);
    }
}
