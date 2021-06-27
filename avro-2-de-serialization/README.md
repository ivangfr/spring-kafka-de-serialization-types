# spring-kafka-de-serialization-types
## `> avro-2-de-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` using `StringSerializer` and the message `value` using `KafkaAvroSerializer`;
- Consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `KafkaAvroDeserializer`;
- This type of serialization uses `Schema Registry`;
- The Java class generated from the `Avro` schema **MUST** have the same `name` and `package (or namespace)` in the producer and the consumer;
- Producer creates the Kafka topics and Consumer doesn't.

## Start Environment

Before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained in [Start Environment](https://github.com/ivangfr/spring-kafka-de-serialization-types#start-environment) section of the main README

## Running applications using Maven

> **Note:** run `avro-2-producer-service` first so that it can create the `Kafka` topics

- **avro-2-producer-service**

  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects avro-2-de-serialization/avro-2-producer-service
    ```
    > The Java class `com.mycompany.commons.avroserialization.avro.NewsMessage` is generated by the Avro file `news-message.avsc` present in `src/main/resources/avro` by running the command
    > ```
    > ./mvnw generate-sources --projects avro-2-de-serialization/avro-2-producer-service
    > ```
  - As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `avro-2-de-serialization-news`. The default `delay` between messages is `3 seconds`.

- **avro-2-consumer-service**

  - Open another terminal and make sure you are in `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects avro-2-de-serialization/avro-2-consumer-service
    ```
    > The Java class `com.mycompany.commons.avroserialization.avro.NewsMessage` is generated by the Avro file `news-message.avsc` present in `src/main/resources/avro` by running the command
    > ```
    > ./mvnw generate-sources --projects avro-2-de-serialization/avro-2-consumer-service
    > ```
  - Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `avro-2-de-serialization-news`

## Running applications as Docker containers

- ### Build Docker images

  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run the following script to build the images
    - JVM
      ```
      ./docker-build.sh avro-2-de-serialization
      ```
    - Native
      ```
      ./docker-build.sh avro-2-de-serialization native
      ```

- ### Environment variables

  **avro-2-producer-service** and **avro-2-consumer-service**

  | Environment Variable   | Description                                                             |
  | ---------------------- | ----------------------------------------------------------------------- |
  | `KAFKA_HOST`           | Specify host of the `Kafka` message broker to use (default `localhost`) |
  | `KAFKA_PORT`           | Specify port of the `Kafka` message broker to use (default `29092`)     |
  | `SCHEMA_REGISTRY_HOST` | Specify host of the `Schema Registry` to use (default `localhost`)      |
  | `SCHEMA_REGISTRY_PORT` | Specify port of the `Schema Registry` to use (default `8081`)           |

- ### Run Docker containers

  > **Note:** run `avro-2-producer-service` first so that it can create the `Kafka` topics

  - **avro-2-producer-service**

    In a terminal, run the following Docker command
    ```
    docker run --rm --name avro-2-producer-service -p 9086:9086 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 -e SCHEMA_REGISTRY_HOST=schema-registry \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/avro-2-producer-service:1.0.0
    ```

  - **avro-2-consumer-service**

    In another terminal, run the Docker command below
    ```
    docker run --rm --name avro-2-consumer-service -p 9087:9087 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 -e SCHEMA_REGISTRY_HOST=schema-registry \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/avro-2-consumer-service:1.0.0
    ```

## Shutdown

- Go to the terminals where the applications are running and press `Ctrl+C`
- Stop the services present in `docker-compose.yml` as explained in [Shutdown](https://github.com/ivangfr/spring-kafka-de-serialization-types#shutdown) section of the main README

## Cleanup

To remove the Docker images created by this example, go to a terminal and, inside `spring-kafka-de-serialization-types` root folder, run the following script
```
./remove-docker-images.sh avro-2-de-serialization
```