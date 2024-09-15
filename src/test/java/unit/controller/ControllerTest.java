package unit.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.epam.controller.SongController;
import com.epam.dto.MetadataDto;
import com.epam.repository.SongRepository;
import com.epam.service.SongService;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unit.objectmothers.ObjectMother;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private SongController songController;

    @Mock
    private SongService songService;

    @Mock
    private SongRepository songRepository;

    @Test
    void testUploadMetadata(){
        MetadataDto metadataDto = ObjectMother.metadataDto();
        Integer expectedResult = 1;

        when(songService.save(metadataDto)).thenReturn(expectedResult);

        ResponseEntity<?> actualResponse = songController.uploadMetadata(metadataDto);

        assertThat(actualResponse.getBody()).isEqualTo(expectedResult);
        verify(songService).save(metadataDto);
    }

    @Test
    void testGetSong(){
        Integer songId = 1;
        MetadataDto expectedDto = ObjectMother.metadataDto();

        when(songService.getSong(songId)).thenReturn(expectedDto);

        ResponseEntity<?> actualResponse = songController.getSong(songId);

        assertThat(actualResponse.getBody()).isEqualTo(expectedDto);
        verify(songService).getSong(songId);
    }

    @Test
    void testDeleteSong(){
        String ids = "1";
        Integer id = 1;
        when(songService.deleteSongs(ids)).thenReturn(Collections.singletonList(id));

        ResponseEntity<?> response = songController.deleteSong(ids);

        assertThat(HttpStatus.OK).isEqualTo(response.getStatusCode());
        verify(songService).deleteSongs(ids);
    }

}
