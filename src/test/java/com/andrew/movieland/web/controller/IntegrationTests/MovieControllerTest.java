package com.andrew.movieland.web.controller.IntegrationTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/spring/applicationContext.xml")
class MovieControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Check if response is in json format and is not empty")
    public void testIfResponseIsJsonAndItIncludesMovie() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    @DisplayName("Check that response is ok, type - Json, and size = 5")
    public void testGetThreeRandomMovies() throws Exception {
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(equalTo(5))));
    }

    @Test
    @DisplayName("Test get all movies sorted by ascending price")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

    public void testGetAllMoviesSortedByAscendingPrice() throws Exception {
        mockMvc.perform(get("/movie?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].price").value(0.1))
                .andExpect(jsonPath("$[0].nameNative").value("Test 1"))
                .andExpect(jsonPath("$[1].price").value(0.2))
                .andExpect(jsonPath("$[1].nameNative").value("Test 2"))
                .andExpect(jsonPath("$[2].price").value(0.3))
                .andExpect(jsonPath("$[2].nameNative").value("Test 3"));


    }

    @Test
    @DisplayName("Test get all movies sorted by descending price")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetAllMoviesSortedByDescendingPrice() throws Exception {
        mockMvc.perform(get("/movie?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].price").value(1200))
                .andExpect(jsonPath("$[0].nameNative").value("Test 5"))
                .andExpect(jsonPath("$[1].price").value(1111))
                .andExpect(jsonPath("$[1].nameNative").value("Test 4"));
    }

    @Test
    @DisplayName("Test get all movies sorted by descending rating")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetAllMoviesSortedByDescendingRating() throws Exception {
        mockMvc.perform(get("/movie?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].rating").value(12))
                .andExpect(jsonPath("$[0].nameNative").value("Test 5"))
                .andExpect(jsonPath("$[1].rating").value(11))
                .andExpect(jsonPath("$[1].nameNative").value("Test 4"));
    }

    @Test
    @DisplayName("Test get all movies sorted by ascending rating")
    public void testGetAllMoviesSortedByAscendingRating() throws Exception {
        mockMvc.perform(get("/movie?rating=asc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test get all movies sorted by ascending price")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

    public void testGetMovieByGenreSortedByAscendingPrice() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].price").value(0.1))
                .andExpect(jsonPath("$[0].nameNative").value("Test 1"))
                .andExpect(jsonPath("$[1].price").value(0.2))
                .andExpect(jsonPath("$[1].nameNative").value("Test 2"))
                .andExpect(jsonPath("$[2].price").value(0.3))
                .andExpect(jsonPath("$[2].nameNative").value("Test 3"));
    }

    @Test
    @DisplayName("Test get all movies sorted by descending price")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetMovieByGenreSortedByDescendingPrice() throws Exception {
        mockMvc.perform(get("/movie/genre/1?price=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].price").value(1200))
                .andExpect(jsonPath("$[0].nameNative").value("Test 5"))
                .andExpect(jsonPath("$[1].price").value(1111))
                .andExpect(jsonPath("$[1].nameNative").value("Test 4"));
    }

    @Test
    @DisplayName("Test get all movies sorted by descending rating")
    @Sql(scripts = "classpath:add_test-cases_to_movie_table.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:delete_test_cases_from_movies-table.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetMovieByGenreSortedByDescendingRating() throws Exception {
        mockMvc.perform(get("/movie/genre/1?rating=desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].rating").value(12))
                .andExpect(jsonPath("$[0].nameNative").value("Test 5"))
                .andExpect(jsonPath("$[1].rating").value(11))
                .andExpect(jsonPath("$[1].nameNative").value("Test 4"));
    }

}