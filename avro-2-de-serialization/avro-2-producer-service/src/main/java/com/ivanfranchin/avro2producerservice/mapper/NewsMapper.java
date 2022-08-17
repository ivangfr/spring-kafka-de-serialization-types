package com.ivanfranchin.avro2producerservice.mapper;

import com.ivanfranchin.avro2producerservice.kafka.event.News;
import com.ivanfranchin.commons.avroserialization.avro.NewsMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);
}
