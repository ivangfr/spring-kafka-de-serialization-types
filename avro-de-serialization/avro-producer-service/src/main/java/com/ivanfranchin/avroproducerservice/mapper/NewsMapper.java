package com.ivanfranchin.avroproducerservice.mapper;

import com.ivanfranchin.avroproducerservice.avro.NewsMessage;
import com.ivanfranchin.avroproducerservice.kafka.event.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);
}
