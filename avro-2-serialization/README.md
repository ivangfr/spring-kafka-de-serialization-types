# springboot-spring-kafka

## avro-2-serialization

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that
listens those messages from `Kafka`.

- The producer serializes the message `key` using `StringSerializer` and the message `value` using `KafkaAvroSerializer`.

- The consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `KafkaAvroDeserializer`.

- This type of serialization uses `Schema Registry`.

- The Java class generated from the `Avro` schema **MUST** have the same `name` and `package (or namespace)` on producer
and consumer.

## How to run

### avro-2-producer-service

- Open a new terminal and inside `springboot-spring-kafka/avro-2-serialization/avro-2-producer-service` run
```
./mvn spring-boot:run
```

- As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka`
topic `avro-2-serialization-news`. The default `delay` between messages is `3 seconds`.

### avro-2-consumer-service

- Open a new terminal and inside `springboot-spring-kafka/avro-2-serialization/avro-2-consumer-service` run
```
./mvn spring-boot:run
```

- Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic
`avro-2-serialization-news`.