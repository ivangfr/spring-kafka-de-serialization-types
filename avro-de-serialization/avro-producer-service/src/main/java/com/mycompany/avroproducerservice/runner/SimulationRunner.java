package com.mycompany.avroproducerservice.runner;

import com.mycompany.avroproducerservice.kafka.NewsProducer;
import com.mycompany.avroproducerservice.mapper.NewsMapper;
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
