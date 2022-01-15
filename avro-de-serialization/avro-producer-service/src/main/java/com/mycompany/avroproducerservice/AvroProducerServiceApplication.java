package com.mycompany.avroproducerservice;

import com.mycompany.avroproducerservice.kafka.AvroSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeHint;

@TypeHint(types = AvroSerializer.class)
@SpringBootApplication
public class AvroProducerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvroProducerServiceApplication.class, args);
    }
}
