package com.mycompany.avroproducerservice.mapper;

import com.mycompany.avroproducerservice.avro.NewsMessage;
import com.mycompany.avroproducerservice.kafka.event.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);
}
