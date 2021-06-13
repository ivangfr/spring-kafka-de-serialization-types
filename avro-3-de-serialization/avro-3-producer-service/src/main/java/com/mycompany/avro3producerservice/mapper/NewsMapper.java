package com.mycompany.avro3producerservice.mapper;

import com.mycompany.avro3producerservice.avro.NewsMessage;
import com.mycompany.avro3producerservice.domain.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMessage toNewsMessage(News news);

}
