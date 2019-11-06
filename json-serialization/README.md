# `springboot-spring-kafka`

## json-serialization

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that
listens those messages from `Kafka`.

- The producer serializes the message `key` using `StringSerializer` and the message `value` using `JsonSerializer`.
- The consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `JsonDeserializer`.

## How to run

> Note. before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running
as explained in the main README.

### json-producer-service

In a terminal, inside `springboot-spring-kafka` root folder, run
```
./mvnw spring-boot:run --projects json-serialization/json-producer-service
```

As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka`
topic `json-serialization-news`. The default `delay` between messages is `3 seconds`.

### json-consumer-service

Open a new terminal and, inside `springboot-spring-kafka` root folder, run
```
./mvnw spring-boot:run --projects json-serialization/json-consumer-service
```

Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic
`json-serialization-news`.