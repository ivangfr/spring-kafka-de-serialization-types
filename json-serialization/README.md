# springboot-spring-kafka
## `> json-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` using `StringSerializer` and the message `value` using `JsonSerializer`
- Consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `JsonDeserializer`

## How to run producer and consumer

> **Note:** before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained at [Start Environment](https://github.com/ivangfr/springboot-spring-kafka#start-environment) section of the main README

### json-producer-service

- Open a terminal navigate to `springboot-spring-kafka` root folder

- Run application
  ```
  ./mvnw spring-boot:run --projects json-serialization/json-producer-service
  ```

  As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `json-serialization-news`. The default `delay` between messages is `3 seconds`

### json-consumer-service

- Open another terminal and make sure you are in `springboot-spring-kafka` root folder

- Run application
  ```
  ./mvnw spring-boot:run --projects json-serialization/json-consumer-service
  ```

  Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `json-serialization-news`

## How to stop producer and consumer

Go to the terminal where the applications are running and press `Ctrl+C`