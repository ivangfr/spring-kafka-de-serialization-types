package com.mycompany.avro2producerservice.mapper;

import com.mycompany.avro2producerservice.kafka.event.News;
import com.mycompany.commons.avroserialization.avro.NewsMessage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);

}
