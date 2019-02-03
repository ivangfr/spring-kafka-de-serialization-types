package com.mycompany.jsonproducerservice.service;

import com.mycompany.jsonproducerservice.domain.News;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class RandomNewsImpl implements RandomNews {

    private final Random random = new Random();

    @Override
    public News generate() {
        News news = new News();
        news.setId(UUID.randomUUID().toString());
        int mediaId = random.nextInt(medias.size());
        news.setFromId(mediaId + 1);
        news.setFromName(medias.get(mediaId));
        news.setTitle(titles.get(random.nextInt(titles.size())));
        return news;
    }

    private static List<String> medias = Arrays.asList("CNN", "New York Times", "BBC", "Al-Jazeera");
    private static List<String> titles = Arrays.asList(
            "Brexit is killing investment in UK car industry",
            "Jaguar Land Rover is slashing 4,500 jobs",
            "Nigeria's VP safe after helicopter crash",
            "Inmates shivering in NY prison power outage",
            "Did Finland's free money experiment work?",
            "Education shake-up is dark day for Europe",
            "Trump: Stone defending himself very well",
            "TSA agent falls to death at Orlando airport",
            "Private search for footballer missing for weeks",
            "Massive crowds take to streets in Venezuela",
            "Controversial doctor joins Trump team",
            "Snowstorm halts ski World Cup",
            "Pope makes first papal visit to Arab Gulf state");

}
