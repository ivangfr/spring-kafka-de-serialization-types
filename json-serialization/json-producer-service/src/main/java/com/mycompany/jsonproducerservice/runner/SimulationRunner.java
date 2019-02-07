package com.mycompany.jsonproducerservice.runner;

import com.mycompany.jsonproducerservice.domain.News;
import com.mycompany.jsonproducerservice.kafka.NewsProducer;
import lombok.extern.slf4j.Slf4j;
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

    public SimulationRunner(NewsProducer newsProducer, RandomNews randomNews) {
        this.newsProducer = newsProducer;
        this.randomNews = randomNews;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            News news = randomNews.generate();
            newsProducer.send(news);

            Thread.sleep(sleep);
        }
    }
}
