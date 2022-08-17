package com.ivanfranchin.stringproducerservice.runner;

import com.ivanfranchin.stringproducerservice.kafka.NewsProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final NewsProducer newsProducer;
    private final RandomNews randomNews;

    public SimulationRunner(NewsProducer newsProducer, RandomNews randomNews) {
        this.newsProducer = newsProducer;
        this.randomNews = randomNews;
    }

    @Value("${simulation.sleep}")
    private Integer sleep;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            newsProducer.send(randomNews.generate());
            Thread.sleep(sleep);
        }
    }
}
