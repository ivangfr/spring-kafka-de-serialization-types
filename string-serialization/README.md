# springboot-spring-kafka
## `> string-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` and `value` using `StringSerializer`
- Consumer deserializes the message `key` and `value` using `StringDeserializer`

## How to run producer and consumer

> **Note:** before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained at [Start Environment](https://github.com/ivangfr/springboot-spring-kafka#start-environment) section of the main README

### spring-producer-service

- Open a terminal navigate to `springboot-spring-kafka` root folder

- Run application
  ```
  ./mvnw spring-boot:run --projects string-serialization/string-producer-service
  ```

  As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `string-serialization-news`. The default `delay` between messages is `3 seconds`

### spring-consumer-service

- Open another terminal and make sure you are in `springboot-spring-kafka` root folder

- Run application
  ```
  ./mvnw spring-boot:run --projects string-serialization/string-consumer-service
  ```

  Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `string-serialization-news`

## How to stop producer and consumer

Go to the terminal where the applications are running and press `Ctrl+C`