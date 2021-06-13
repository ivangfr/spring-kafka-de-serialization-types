# springboot-spring-kafka
## `> json-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` using `StringSerializer` and the message `value` using `JsonSerializer`;
- Consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `JsonDeserializer`;
- Producer creates the Kafka topics and Consumer doesn't.

## Start Environment

Before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained at [Start Environment](https://github.com/ivangfr/springboot-spring-kafka#start-environment) section of the main README

## Running applications using Maven

> **Note:** run `json-producer-service` first so that it can create the `Kafka` topics

- **json-producer-service**

  - Open a terminal navigate to `springboot-spring-kafka` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects json-serialization/json-producer-service
    ```
  - As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `json-serialization-news`. The default `delay` between messages is `3 seconds`.

- **json-consumer-service**

  - Open another terminal and make sure you are in `springboot-spring-kafka` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects json-serialization/json-consumer-service
    ```
  - Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `json-serialization-news`

## Running applications as Docker containers

- ### Build Docker images

  - Open a terminal navigate to `springboot-spring-kafka` root folder
  - Run the following script to build the images
    - JVM
      ```
      ./docker-build.sh json-serialization
      ```
    - Native
      ```
      ./docker-build.sh json-serialization native
      ```

- ### Environment variables

  **json-producer-service** and **json-consumer-service**

  | Environment Variable | Description                                                             |
  | -------------------- | ----------------------------------------------------------------------- |
  | `KAFKA_HOST`         | Specify host of the `Kafka` message broker to use (default `localhost`) |
  | `KAFKA_PORT`         | Specify port of the `Kafka` message broker to use (default `29092`)     |

- ### Run Docker containers

  > **Note:** run `json-producer-service` first so that it can create the `Kafka` topics

  - **json-producer-service**

    In a terminal, run the following Docker command
    ```
    docker run --rm --name json-producer-service -p 9082:9082 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=springboot-spring-kafka_default \
      ivanfranchin/json-producer-service:1.0.0
    ```

  - **json-consumer-service**

    In another terminal, run the Docker command below
    ```
    docker run --rm --name json-consumer-service -p 9083:9083 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=springboot-spring-kafka_default \
      ivanfranchin/json-consumer-service:1.0.0
    ```

## Shutdown

Go to the terminals where the applications are running and press `Ctrl+C`
