package com.andrew.movieland.web.controller;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movie")
@Slf4j
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }
}

