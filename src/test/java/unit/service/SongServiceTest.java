package unit.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;
import com.epam.mapstruct.MetadataMapper;
import com.epam.repository.SongRepository;
import com.epam.service.SongService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import unit.objectmothers.ObjectMother;

@ExtendWith(MockitoExtension.class)
public class SongServiceTest {

    @InjectMocks
    private SongService songService;

    @Mock
    private MetadataMapper mapper;

    @Mock
    private SongRepository songRepository;

    @Test
    void testSave(){

        Metadata metadata = ObjectMother.metadata();
        MetadataDto metadataDto = ObjectMother.metadataDto();
        Integer expected = 1;

        when(mapper.toMetadata(metadataDto)).thenReturn(metadata);
        when(songRepository.save(any(Metadata.class))).thenReturn(metadata);

        Integer resultId = songService.save(metadataDto);

        assertThat(resultId).isEqualTo(expected);

        verify(mapper).toMetadata(metadataDto);
        verify(songRepository).save(metadata);
    }
}
