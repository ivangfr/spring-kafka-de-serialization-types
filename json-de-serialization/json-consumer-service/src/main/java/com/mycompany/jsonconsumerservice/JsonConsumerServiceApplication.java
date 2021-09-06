package com.mycompany.jsonconsumerservice;

import com.mycompany.jsonconsumerservice.kafka.News;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeHint;

// Add the @TypeHint below due to this [issue #659](https://github.com/spring-projects-experimental/spring-native/issues/659)
@TypeHint(types = News.class)
@SpringBootApplication
public class JsonConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonConsumerServiceApplication.class, args);
    }

}
