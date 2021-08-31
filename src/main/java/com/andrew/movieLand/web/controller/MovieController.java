package com.andrew.movieLand.web.controller;

import com.andrew.movieLand.entity.Movie;
import com.andrew.movieLand.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1/movie")
public class MovieController {
@Autowired
    MovieService movieService;

    @GetMapping
    @ResponseBody
    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieService.getAllMovies();
        return movieList;
    }
}
