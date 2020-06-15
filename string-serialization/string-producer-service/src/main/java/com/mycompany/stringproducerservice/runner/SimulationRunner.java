package com.mycompany.stringproducerservice.runner;

import com.mycompany.stringproducerservice.kafka.NewsProducer;
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
    private final RandomNews randomNews;

    @Override
    public void run(String... args) throws InterruptedException {
        while (true) {
            newsProducer.send(randomNews.generate());
            Thread.sleep(sleep);
        }
    }
}
