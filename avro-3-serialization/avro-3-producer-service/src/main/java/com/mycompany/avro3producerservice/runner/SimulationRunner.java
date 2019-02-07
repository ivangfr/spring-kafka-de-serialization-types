package com.mycompany.avro3producerservice.runner;

import com.mycompany.avro3producerservice.avro.NewsMessage;
import com.mycompany.avro3producerservice.domain.News;
import com.mycompany.avro3producerservice.kafka.NewsProducer;
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

    private final NewsProducer newsProducer;
    private final RandomNews randomNews;
    private final MapperFacade mapperFacade;

    public SimulationRunner(NewsProducer newsProducer, RandomNews randomNews, MapperFacade mapperFacade) {
        this.newsProducer = newsProducer;
        this.randomNews = randomNews;
        this.mapperFacade = mapperFacade;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            News news = randomNews.generate();
            newsProducer.send(mapperFacade.map(news, NewsMessage.class));

            Thread.sleep(sleep);
        }
    }
}
