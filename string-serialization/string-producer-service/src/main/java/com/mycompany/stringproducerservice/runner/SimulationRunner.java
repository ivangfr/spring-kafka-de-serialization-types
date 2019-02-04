package com.mycompany.stringproducerservice.runner;

import com.mycompany.stringproducerservice.domain.News;
import com.mycompany.stringproducerservice.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
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

    public SimulationRunner(KafkaProducer kafkaProducer, RandomNews randomNews) {
        this.kafkaProducer = kafkaProducer;
        this.randomNews = randomNews;
    }

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            News news = randomNews.generate();
            kafkaProducer.send(news);

            Thread.sleep(sleep);
        }
    }
}
