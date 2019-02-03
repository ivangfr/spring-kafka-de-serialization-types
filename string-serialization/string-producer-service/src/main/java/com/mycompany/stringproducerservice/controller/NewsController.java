package com.mycompany.stringproducerservice.controller;

import com.mycompany.stringproducerservice.domain.News;
import com.mycompany.stringproducerservice.dto.NewsDto;
import com.mycompany.stringproducerservice.kafka.KafkaProducer;
import com.mycompany.stringproducerservice.service.RandomNews;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class NewsController {

    private final KafkaProducer kafkaProducer;
    private final RandomNews randomNews;
    private final MapperFacade mapperFacade;

    public NewsController(KafkaProducer kafkaProducer, RandomNews randomNews, MapperFacade mapperFacade) {
        this.kafkaProducer = kafkaProducer;
        this.randomNews = randomNews;
        this.mapperFacade = mapperFacade;
    }

    @PostMapping("/send/news")
    public String sendNews(@Valid @RequestBody NewsDto newsDto) {
        News news = mapperFacade.map(newsDto, News.class);
        news.setId(UUID.randomUUID().toString());
        kafkaProducer.send(news);
        return String.format("%s\n", news.getId());
    }

    @PostMapping("/send/news/randomly")
    public String sendNewsRandomly() {
        News news = randomNews.generate();
        kafkaProducer.send(news);
        return String.format("%s\n", news.getId());
    }

}
