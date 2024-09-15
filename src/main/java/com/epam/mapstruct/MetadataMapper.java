package com.epam.mapstruct;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MetadataMapper {

    Metadata toMetadata(MetadataDto metadataDto);

    MetadataDto toMetadataDto(Metadata metadata);

}
