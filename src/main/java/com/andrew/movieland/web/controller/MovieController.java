package com.andrew.movieland.web.controller;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movie")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        log.info("Requesting find all");
        return movieService.findAll();
    }

    @GetMapping("/random")
    public List<Movie> findRandom() {
        log.info("Requesting random");
        return movieService.getRandom(5);
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> findByGenre(@PathVariable int genreId) {
        return movieService.findByGenre(genreId);
    }
}

