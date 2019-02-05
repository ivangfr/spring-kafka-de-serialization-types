package com.mycompany.avroproducerservice.runner;

import com.mycompany.avroproducerservice.avro.NewsMessage;
import com.mycompany.avroproducerservice.domain.News;
import com.mycompany.avroproducerservice.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimulationRunner implements CommandLineRunner {

    @Value("${simulation.sleep}")
    private Integer sleep;

    private final KafkaProducer kafkaProducer;
    private final RandomNews randomNews;
    private final MapperFacade mapperFacade;

    public SimulationRunner(KafkaProducer kafkaProducer, RandomNews randomNews, MapperFacade mapperFacade) {
        this.kafkaProducer = kafkaProducer;
        this.randomNews = randomNews;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            News news = randomNews.generate();
            kafkaProducer.send(mapperFacade.map(news, NewsMessage.class));

            Thread.sleep(sleep);
        }
    }
}
