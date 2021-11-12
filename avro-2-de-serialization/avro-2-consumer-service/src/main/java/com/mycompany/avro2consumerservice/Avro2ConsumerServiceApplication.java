package com.mycompany.avro2consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;

@NativeHint(options = "--enable-url-protocols=http")
@SpringBootApplication
public class Avro2ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Avro2ConsumerServiceApplication.class, args);
    }
}
