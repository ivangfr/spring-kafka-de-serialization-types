# springboot-spring-kafka

## json-serialization

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that
listens those messages from `Kafka`.

- The producer serializes the message `key` using `StringSerializer` and the message `value` using `JsonSerializer`.

- The consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `JsonDeserializer`.

## How to run

### json-producer-service

- Open a new terminal and inside `springboot-spring-kafka/json-serialization/json-producer-service` run
```
./mvn spring-boot:run
```

- As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka`
topic `json-serialization-news`. The default `delay` between messages is `3 seconds`.

### json-consumer-service

- Open a new terminal and inside `springboot-spring-kafka/json-serialization/json-consumer-service` run
```
./mvn spring-boot:run
```

- Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic
`json-serialization-news`.