package com.ivanfranchin.stringproducerservice.runner;

import com.ivanfranchin.stringproducerservice.kafka.NewsProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final NewsProducer newsProducer;
    private final RandomNews randomNews;

    public SimulationRunner(NewsProducer newsProducer, RandomNews randomNews) {
        this.newsProducer = newsProducer;
        this.randomNews = randomNews;
    }

    @Value("${simulation.messages.interval}")
    private Integer interval;

    @Override
    public void run(String... args) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(this::generateAndSendNews, 0, interval, TimeUnit.MILLISECONDS);
    }

    private void generateAndSendNews() {
        newsProducer.send(randomNews.generate());
    }
}
