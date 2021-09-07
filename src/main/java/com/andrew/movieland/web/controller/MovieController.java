package com.andrew.movieland.web.controller;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.service.DefaultMovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movie")
@Slf4j
public class MovieController {
    private DefaultMovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        log.info("Requesting find all");
        return movieService.findAll();
    }

    @GetMapping("/random")
    public List<Movie> findRandom(@RequestParam(defaultValue = "5") int randomMovieSQuantity) {
        log.info("Requesting random");
        return movieService.getRandom(randomMovieSQuantity);
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> findByGenre(@PathVariable int genreId) {
        return movieService.findByGenre(genreId);
    }
}

