package com.ivanfranchin.avro2producerservice.simulation;

import com.ivanfranchin.avro2producerservice.news.NewsEmitter;
import com.ivanfranchin.avro2producerservice.news.News;
import com.ivanfranchin.commons.avroserialization.avro.NewsMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class SimulationRunner implements CommandLineRunner {

    private final NewsEmitter newsEmitter;
    private final RandomNews randomNews;

    public SimulationRunner(NewsEmitter newsEmitter, RandomNews randomNews) {
        this.newsEmitter = newsEmitter;
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
        newsEmitter.send(toNewsMessage(randomNews.generate()));
    }

    private NewsMessage toNewsMessage(News news) {
        return new NewsMessage(news.id(), news.fromId(), news.fromName(), news.title());
    }
}
