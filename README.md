# `springboot-spring-kafka`

The goal of this project is to play with [`Spring Kafka`](https://docs.spring.io/spring-kafka/reference/htmlsingle/).
We've implemented 5 examples of producer and consumer services that exchanges messages through
[`Kafka`](https://kafka.apache.org/) using different types of serialization and approaches.

# Start Environment

## Docker Compose

1. Open one terminal

2. Inside `/springboot-spring-kafka` root folder run

```
docker-compose up -d
```
> To stop and remove containers, networks and volumes type:
> ```
> docker-compose down -v
> ```

3. Wait a little bit until all containers are `Up (healthy)`. To check the status of the containers, run
```
docker-compose ps
```

# Samples

The following samples demonstrate a **producer** that pushes _"News"_ messages to a topic in Kafka and a **consumer**
that listens those messages from Kafka.

![project-diagram-samples](images/project-diagram-samples.png)

## [# string-serialization](https://github.com/ivangfr/springboot-spring-kafka/tree/master/string-serialization)

## [# json-serialization](https://github.com/ivangfr/springboot-spring-kafka/tree/master/json-serialization)

## [# avro-serialization](https://github.com/ivangfr/springboot-spring-kafka/tree/master/avro-serialization)

## [# avro-2-serialization](https://github.com/ivangfr/springboot-spring-kafka/tree/master/avro-2-serialization)

## [# avro-3-serialization](https://github.com/ivangfr/springboot-spring-kafka/tree/master/avro-3-serialization)

# References

- https://codenotfound.com/spring-kafka-consumer-producer-example.html

- https://codenotfound.com/spring-kafka-json-serializer-deserializer-example.html

- https://codenotfound.com/spring-kafka-apache-avro-serializer-deserializer-example.html