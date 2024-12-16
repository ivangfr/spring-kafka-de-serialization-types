package com.ivanfranchin.stringproducerservice.simulation;

import com.ivanfranchin.stringproducerservice.news.News;
import com.ivanfranchin.stringproducerservice.news.NewsEmitter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final NewsEmitter newsEmitter;

    public SimulationRunner(NewsEmitter newsEmitter) {
        this.newsEmitter = newsEmitter;
    }

    @Override
    public void run(String... args) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(this::generateAndSendNews, 0, 3, TimeUnit.SECONDS);
    }

    private void generateAndSendNews() {
        newsEmitter.send(generate());
    }

    private News generate() {
        return new News(UUID.randomUUID().toString(), 1, "Channel", "Title");
    }
}
