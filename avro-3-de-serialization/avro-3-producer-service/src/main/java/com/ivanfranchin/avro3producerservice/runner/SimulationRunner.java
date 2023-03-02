package com.ivanfranchin.avro3producerservice.runner;

import com.ivanfranchin.avro3producerservice.avro.NewsMessage;
import com.ivanfranchin.avro3producerservice.kafka.NewsProducer;
import com.ivanfranchin.avro3producerservice.kafka.event.News;
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
        newsProducer.send(toNewsMessage(randomNews.generate()));
    }

    private NewsMessage toNewsMessage(News news) {
        return new NewsMessage(news.id(), news.fromId(), news.fromName(), news.title());
    }
}
