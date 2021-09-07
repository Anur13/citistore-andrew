package com.andrew.movieland.service;

import com.andrew.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();

    public List<Movie> getRandom(int randomMoviesQuantity);

    public List<Movie> findByGenre(int genreId);
}
