package com.mycompany.avro2producerservice.runner;

import com.mycompany.avro2producerservice.kafka.NewsProducer;
import com.mycompany.avro2producerservice.mapper.NewsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SimulationRunner implements CommandLineRunner {

    @Value("${simulation.sleep}")
    private Integer sleep;

    private final NewsProducer newsProducer;
    private final NewsMapper newsMapper;
    private final RandomNews randomNews;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            newsProducer.send(newsMapper.toNewsMessage(randomNews.generate()));
            Thread.sleep(sleep);
        }
    }
}
