package com.mycompany.avro2producerservice.runner;

import com.mycompany.avro2producerservice.kafka.NewsProducer;
import com.mycompany.avro2producerservice.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final NewsProducer newsProducer;
    private final NewsMapper newsMapper;
    private final RandomNews randomNews;

    public SimulationRunner(NewsProducer newsProducer, NewsMapper newsMapper, RandomNews randomNews) {
        this.newsProducer = newsProducer;
        this.newsMapper = newsMapper;
        this.randomNews = randomNews;
    }

    @Value("${simulation.sleep}")
    private Integer sleep;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            newsProducer.send(newsMapper.toNewsMessage(randomNews.generate()));
            Thread.sleep(sleep);
        }
    }
}
