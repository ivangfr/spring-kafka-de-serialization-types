package com.ivanfranchin.avro3producerservice.mapper;

import com.ivanfranchin.avro3producerservice.avro.NewsMessage;
import com.ivanfranchin.avro3producerservice.kafka.event.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);
}
