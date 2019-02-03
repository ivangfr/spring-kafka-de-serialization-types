# springboot-spring-kafka

## Goal

The goal of this project is ...

### Docker Compose

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

### string-serialization

### json-serialization

### avro-serialization

### avro-with-schema-registry-serialization

- Post own news
```
curl -X POST http://localhost:9080/api/send/news \
  -H "Content-Type: application/json" \
  -d '{"fromId": 1, "fromName": "New York Times", "title": "Scolari wins Brazilian championship with Palmeiras"}'
```

- Post randomly
```
curl -X POST http://localhost:9080/api/send/news/randomly
```

