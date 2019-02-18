# `springboot-spring-kafka`

# string-serialization

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that
listens those messages from `Kafka`.

- The producer serializes the message `key` and `value` using `StringSerializer`.

- The consumer deserializes the message `key` and `value` using `StringDeserializer`.

# How to run

> **Note**: before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running
as explained in the main README.

## spring-producer-service

- In terminal, inside `springboot-spring-kafka` root folder, run
```
./mvnw spring-boot:run --projects string-serialization/string-producer-service
```

- As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka`
topic `string-serialization-news`. The default `delay` between messages is `3 seconds`.

## spring-consumer-service

- Open a new terminal and, inside `springboot-spring-kafka` root folder, run
```
./mvnw spring-boot:run --projects string-serialization/string-consumer-service
```

- Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic
`string-serialization-news`.