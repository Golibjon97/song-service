package com.epam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class MetadataDto {
    private String name;
    private String artist;
    private String album;
    private String length;
    private Integer s3LocationId;
    private String year;
}
