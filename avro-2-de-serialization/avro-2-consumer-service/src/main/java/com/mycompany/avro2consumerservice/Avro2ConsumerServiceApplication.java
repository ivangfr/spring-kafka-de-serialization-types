package com.mycompany.avro2consumerservice;

import io.confluent.kafka.serializers.context.NullContextNameStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

@NativeHint(
        options = "--enable-url-protocols=http",
        types = @TypeHint(types = NullContextNameStrategy.class)
)
@SpringBootApplication
public class Avro2ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Avro2ConsumerServiceApplication.class, args);
    }
}
