# spring-kafka-de-serialization-types
## `> string-de-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` and `value` using `StringSerializer`;
- Consumer deserializes the message `key` and `value` using `StringDeserializer`;
- Producer creates the Kafka topics and Consumer doesn't.

## Start Environment

Before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained in [Start Environment](https://github.com/ivangfr/spring-kafka-de-serialization-types#start-environment) section of the main README

## Running applications using Maven

> **Note:** run `string-producer-service` first so that it can create the `Kafka` topics

- **string-producer-service**

  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects string-de-serialization/string-producer-service
    ```
  - As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `string-de-serialization-news`. The default `delay` between messages is `3 seconds`.

- **string-consumer-service**

  - Open another terminal and make sure you are in `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects string-de-serialization/string-consumer-service
    ```
  - Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `string-de-serialization-news`

## Running applications as Docker containers

- ### Build Docker images
  
  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run the following script to build the images
    - JVM
      ```
      ./docker-build.sh string-de-serialization
      ```
    - Native
      ```
      ./docker-build.sh string-de-serialization native
      ```

- ### Environment variables

  **string-producer-service** and **string-consumer-service**
  
  | Environment Variable | Description                                                             |
  | -------------------- | ----------------------------------------------------------------------- |
  | `KAFKA_HOST`         | Specify host of the `Kafka` message broker to use (default `localhost`) |
  | `KAFKA_PORT`         | Specify port of the `Kafka` message broker to use (default `29092`)     |

- ### Run Docker containers

  > **Note:** run `string-producer-service` first so that it can create the `Kafka` topics

  - **string-producer-service**
    
    In a terminal, run the following Docker command
    ```
    docker run --rm --name string-producer-service -p 9080:9080 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/string-producer-service:1.0.0
    ```

  - **string-consumer-service**
    
    In another terminal, run the Docker command below
    ```
    docker run --rm --name string-consumer-service -p 9081:9081 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/string-consumer-service:1.0.0
    ```

## Shutdown

- Go to the terminals where the applications are running and press `Ctrl+C`
- Stop the services present in `docker-compose.yml` as explained in [Shutdown](https://github.com/ivangfr/spring-kafka-de-serialization-types#shutdown) section of the main README

## Cleanup

To remove the Docker images created by this example, go to a terminal and, inside `spring-kafka-de-serialization-types` root folder, run the following script
```
./remove-docker-images.sh string-de-serialization
```
