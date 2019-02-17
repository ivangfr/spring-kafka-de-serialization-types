# `springboot-spring-kafka`

# avro-3-serialization

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that
listens those messages from `Kafka`.

- The producer serializes the message `key` using `StringSerializer` and the message `value` using `KafkaAvroSerializer`.

- The consumer deserializes message `key` using `StringSerializer` to the message `value` using `SpecificAvroWithSchemaDeserializer`.

- This type of serialization/deserialization uses `Schema Registry`.

- The Java class generated from the `Avro` schema **DO NOT** need to have the same `name` and `package (or namespace)`
on producer and consumer.

- We needed to implement the class `SpecificAvroWithSchemaDeserializer`.

# How to run

> Note: before starting producer and consumer, the containers present in docker-compose up and running as explained in
the main README.

## avro-3-producer-service

- In a terminal, inside `springboot-spring-kafka` root foler, run
```
./mvnw spring-boot:run --projects avro-3-serialization/avro-3-producer-service
```

- As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka`
topic `avro-3-serialization-news`. The default `delay` between messages is `3 seconds`.

## avro-3-consumer-service

- Open a new terminal and, inside `springboot-spring-kafka` root folder, run
```
./mvnw spring-boot:run --projects avro-3-serialization/avro-3-consumer-service
```

- Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic
`avro-3-serialization-news`.