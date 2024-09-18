package com.epam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetadataDto {
    private String name;
    private String artist;
    private String album;
    private String length;
    private Integer s3LocationId;
    private String year;
}
