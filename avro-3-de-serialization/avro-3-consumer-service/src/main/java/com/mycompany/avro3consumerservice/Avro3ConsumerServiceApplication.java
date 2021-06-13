package com.mycompany.avro3consumerservice;

import com.mycompany.avro3consumerservice.avro.NewsMessage;
import com.mycompany.avro3consumerservice.kafka.SpecificAvroWithSchemaDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.TypeHint;

@TypeHint(types = {
		SpecificAvroWithSchemaDeserializer.class,
		NewsMessage.class
})
@SpringBootApplication
public class Avro3ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Avro3ConsumerServiceApplication.class, args);
	}

}

