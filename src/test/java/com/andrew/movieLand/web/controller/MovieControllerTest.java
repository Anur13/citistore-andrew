package com.andrew.movieLand.web.controller;

import com.andrew.movieLand.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/spring/app-servlet.xml")
class MovieControllerTest {
    MockMvc mockMvc;
    @Autowired
    MovieService movieService;
    @Autowired
    WebApplicationContext webApplicationContext;
    ResultMatcher ok = MockMvcResultMatchers.status().isOk();

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    @DisplayName("Check if response is in json format and that it contains a movie")
    public void testIfResponseIsJsonAndItIncludesMovie() throws Exception {
        String mockTestResult = "The Shawshank Redemption";

        RequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/movie");
        MvcResult mvcResult = mockMvc.perform(builder).andExpect(ok)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        assertTrue(res.contains(mockTestResult));
    }


}