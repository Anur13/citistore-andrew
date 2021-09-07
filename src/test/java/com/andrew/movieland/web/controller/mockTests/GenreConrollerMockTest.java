package com.andrew.movieland.web.controller.mockTests;

import com.andrew.movieland.entity.Genre;
import com.andrew.movieland.service.DefaultGenreService;
import com.andrew.movieland.web.controller.GenreConroller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GenreConrollerMockTest {
    private MockMvc mockMvc;
    private DefaultGenreService genreService;

    @BeforeEach
    public void setup() {
        genreService = mock(DefaultGenreService.class);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GenreConroller(genreService)).build();
    }

    @Test
    public void testFindAllWithMock() throws Exception {
        Genre comedy = Genre.builder()
                .id(1)
                .name("comedy")
                .build();

        Genre drama = Genre.builder()
                .id(2)
                .name("drama")
                .build();

        when(genreService.findAll()).thenReturn(List.of(comedy, drama));
        mockMvc.perform(get("/genre")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("comedy"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("drama"));


        verify(genreService, times(1)).findAll();
        verifyNoMoreInteractions(genreService);
    }


}