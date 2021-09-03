package com.andrew.movieland.web.controller;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MovieControllerMockTest {
    private MockMvc mockMvc;
    private MovieService movieService;


    @BeforeEach
    public void setup() throws Exception {
        movieService = mock(MovieService.class);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(movieService)).build();
    }

    @Test
    public void testFindAllWithMock() throws Exception {
        Movie shawshankRedemption = Movie.builder()
                .id(1)
                .nameNative("The Shawshank Redemption")
                .nameRussian("Побег из Шоушенка")
                .releasedDate(LocalDateTime.of(1994, 01, 01, 10, 10))
                .build();
        Movie greenMile = Movie.builder()
                .id(2)
                .nameNative("The Green Mile")
                .nameRussian("Зеленая миля")
                .releasedDate(LocalDateTime.of(1994, 01, 01, 10, 10))
                .build();


        List<Movie> movies = List.of(shawshankRedemption, greenMile);
        when(movieService.findAll()).thenReturn(movies);

        mockMvc.perform(get("/movie")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nameNative").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].nameRussian").value("Побег из Шоушенка"))
                .andExpect(jsonPath("$[0].releasedDate").value("1994"))

                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nameNative").value("The Green Mile"))
                .andExpect(jsonPath("$[1].nameRussian").value("Зеленая миля"))
                .andExpect(jsonPath("$[1].releasedDate").value("1994"));

        verify(movieService, times(1)).findAll();
        verifyNoMoreInteractions(movieService);
    }

}
