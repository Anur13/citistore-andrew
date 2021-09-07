package com.andrew.movieland.dao;

import com.andrew.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {

    public List<Movie> findAll();

    public List<Movie> getRandom(int randomQuantity);

    public List<Movie> getMoviesByGenre(int genreId);
}
