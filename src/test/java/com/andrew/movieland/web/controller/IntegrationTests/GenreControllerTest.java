package com.andrew.movieland.web.controller.IntegrationTests;

import com.andrew.movieland.service.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/spring/applicationContext.xml")
class GenreControllerTest {
    private MockMvc mockMvc;

    @Autowired
    GenreService genreService;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testFindGenreById() {
        String[] genres = new String[]{"драма",
                "криминал",
                "фэнтези",
                "детектив",
                "мелодрама",
                "биография",
                "комедия",
                "фантастика",
                "боевик",
                "триллер",
                "приключения",
                "аниме",
                "мультфильм",
                "семейный",
                "вестерн"};
        for (int i = 0; i < genres.length; i++) {
            int indexOfGenreInDb = i + 1;
            assertEquals(genreService.findById(indexOfGenreInDb).getName(), genres[i]);
        }

    }


}