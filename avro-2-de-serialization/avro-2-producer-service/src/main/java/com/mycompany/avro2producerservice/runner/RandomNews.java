package com.mycompany.avro2producerservice.runner;

import com.mycompany.avro2producerservice.kafka.event.News;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RandomNews {

    public News generate() {
        String id = UUID.randomUUID().toString();
        int mediaId = random.nextInt(medias.size());
        int fromId = mediaId + 1;
        String fromName = medias.get(mediaId);
        String title = titles.get(random.nextInt(titles.size()));
        return News.of(id, fromId, fromName, title);
    }

    private static final Random random = new Random();
    private static final List<String> medias = Arrays.asList("CNN", "New York Times", "BBC", "Al-Jazeera");
    private static final List<String> titles = Arrays.asList(
            "Scolari wins Brazilian championship with Palmeiras",
            "Brexit is killing investment in UK car industry",
            "Jaguar Land Rover is slashing 4,500 jobs",
            "Nigeria's VP safe after helicopter crash",
            "Inmates shivering in NY prison power outage",
            "Did Finland's free money experiment work?",
            "Education shake-up is dark day for Europe",
            "TSA agent falls to death at Orlando airport",
            "Private search for footballer missing for weeks",
            "Massive crowds take to streets in Venezuela",
            "Controversial doctor joins Trump team",
            "Snowstorm halts ski World Cup",
            "Pope makes first papal visit to Arab Gulf state");
}
