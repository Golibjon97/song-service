package com.epam.service;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;

import com.epam.mapstruct.MetadataMapper;
import com.epam.repository.SongRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SongService {

    private final SongRepository songRepository;
    private final MetadataMapper mapper;

    @Autowired
    public SongService(SongRepository songRepository, MetadataMapper mapper) {
        this.songRepository = songRepository;
        this.mapper = mapper;
    }

    public Integer save(MetadataDto metadataDto) {
        log.info("Saving metadata to song db");
        Metadata song = mapper.toMetadata(metadataDto);
        Metadata savedSong = songRepository.save(song);
        return savedSong.getId();
    }

    public MetadataDto getSong(Integer id) {
        log.info("Retrieving song metadata as per the id: {}", id);
        return songRepository
                .findById(id)
                .map(mapper::toMetadataDto)
                .orElseThrow(NotFoundException::new);
    }

    public List<Integer> deleteSongs(String ids) {
        log.info("Deleting the song metadata as per the id: {}", ids);
        return Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .filter(songRepository::existsByS3LocationId)
                .peek(songRepository::deleteByS3Location).toList();
    }
}
