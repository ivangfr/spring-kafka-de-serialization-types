# spring-kafka-de-serialization-types
## `> json-de-serialization`

This sample demonstrates a **producer** that pushes `News` messages to a topic in `Kafka` and a **consumer** that listens those messages from `Kafka`
- Producer serializes the message `key` using `StringSerializer` and the message `value` using `JsonSerializer`;
- Consumer deserializes the message `key` using `StringDeserializer` and the message `value` using `JsonDeserializer`;
- Producer creates the Kafka topics and Consumer doesn't.

## Start Environment

Before starting producer and consumer, the services present in `docker-compose.yml` file must be up and running as explained in [Start Environment](https://github.com/ivangfr/spring-kafka-de-serialization-types#start-environment) section of the main README

## Running applications using Maven

> **Note:** run `json-producer-service` first so that it can create the `Kafka` topics

- **json-producer-service**

  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects json-de-serialization/json-producer-service
    ```
  - As soon as the producer is up and running, it will start pushing automatically and randomly `News` messages to `Kafka` topic `json-de-serialization-news`. The default `delay` between messages is `3 seconds`.

- **json-consumer-service**

  - Open another terminal and make sure you are in `spring-kafka-de-serialization-types` root folder
  - Run application
    ```
    ./mvnw clean spring-boot:run --projects json-de-serialization/json-consumer-service
    ```
  - Once the consumer is up and running, it will start listening `News` messages from the `Kafka` topic `json-de-serialization-news`

## Running applications as Docker containers

- ### Build Docker images

  - Open a terminal navigate to `spring-kafka-de-serialization-types` root folder
  - Run the following script to build the images
    - JVM
      ```
      ./docker-build.sh json-de-serialization
      ```
    - Native
      ```
      ./docker-build.sh json-de-serialization native
      ```

- ### Environment variables

  **json-producer-service** and **json-consumer-service**

  | Environment Variable | Description                                                             |
  |----------------------|-------------------------------------------------------------------------|
  | `KAFKA_HOST`         | Specify host of the `Kafka` message broker to use (default `localhost`) |
  | `KAFKA_PORT`         | Specify port of the `Kafka` message broker to use (default `29092`)     |

- ### Run Docker containers

  > **Note:** run `json-producer-service` first so that it can create the `Kafka` topics

  - **json-producer-service**

    In a terminal, run the following Docker command
    ```
    docker run --rm --name json-producer-service -p 9082:9082 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/json-producer-service:1.0.0
    ```

  - **json-consumer-service**

    In another terminal, run the Docker command below
    ```
    docker run --rm --name json-consumer-service -p 9083:9083 \
      -e KAFKA_HOST=kafka -e KAFKA_PORT=9092 \
      --network=spring-kafka-de-serialization-types_default \
      ivanfranchin/json-consumer-service:1.0.0
    ```

## Shutdown

- Go to the terminals where the applications are running and press `Ctrl+C`
- Stop the services present in `docker-compose.yml` as explained in [Shutdown](https://github.com/ivangfr/spring-kafka-de-serialization-types#shutdown) section of the main README

## Cleanup

To remove the Docker images created by this example, go to a terminal and, inside `spring-kafka-de-serialization-types` root folder, run the following script
```
./remove-docker-images.sh json-de-serialization
```

## Issues

`json-producer-service`: The following exception is thrown when sending a message
```
ERROR 1 --- [           main] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Failed to execute CommandLineRunner
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:770) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:751) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:309) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1301) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1290) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	at com.mycompany.jsonproducerservice.JsonProducerServiceApplication.main(JsonProducerServiceApplication.java:15) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:na]
Caused by: org.apache.kafka.common.errors.SerializationException: Can't serialize data [News(id=23ffee2f-c633-45fa-91f7-04e542ccc2d6, fromId=1, fromName=CNN, title=Jaguar Land Rover is slashing 4,500 jobs)] for topic [json-de-serialization-news]
	at org.springframework.kafka.support.serializer.JsonSerializer.serialize(JsonSerializer.java:216) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.8.1]
	at org.springframework.kafka.support.serializer.JsonSerializer.serialize(JsonSerializer.java:203) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.8.1]
	at org.apache.kafka.clients.producer.KafkaProducer.doSend(KafkaProducer.java:929) ~[na:na]
	at org.apache.kafka.clients.producer.KafkaProducer.send(KafkaProducer.java:889) ~[na:na]
	at org.springframework.kafka.core.DefaultKafkaProducerFactory$CloseSafeProducer.send(DefaultKafkaProducerFactory.java:984) ~[na:na]
	at org.springframework.kafka.core.KafkaTemplate.doSend(KafkaTemplate.java:649) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.8.1]
	at org.springframework.kafka.core.KafkaTemplate.send(KafkaTemplate.java:409) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.8.1]
	at com.mycompany.jsonproducerservice.kafka.NewsProducer.send(NewsProducer.java:21) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:na]
	at com.mycompany.jsonproducerservice.runner.SimulationRunner.run(SimulationRunner.java:22) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:na]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:767) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.6.2]
	... 5 common frames omitted
Caused by: com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class com.mycompany.jsonproducerservice.kafka.event.News and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
	at com.fasterxml.jackson.databind.SerializerProvider.reportBadDefinition(SerializerProvider.java:1300) ~[na:na]
	at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:400) ~[na:na]
	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.failForEmpty(UnknownSerializer.java:46) ~[na:na]
	at com.fasterxml.jackson.databind.ser.impl.UnknownSerializer.serialize(UnknownSerializer.java:29) ~[na:na]
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider._serialize(DefaultSerializerProvider.java:480) ~[na:na]
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:319) ~[na:na]
	at com.fasterxml.jackson.databind.ObjectWriter$Prefetch.serialize(ObjectWriter.java:1518) ~[na:na]
	at com.fasterxml.jackson.databind.ObjectWriter._writeValueAndClose(ObjectWriter.java:1219) ~[na:na]
	at com.fasterxml.jackson.databind.ObjectWriter.writeValueAsBytes(ObjectWriter.java:1109) ~[na:na]
	at org.springframework.kafka.support.serializer.JsonSerializer.serialize(JsonSerializer.java:213) ~[com.mycompany.jsonproducerservice.JsonProducerServiceApplication:2.8.1]
	... 14 common frames omitted
```