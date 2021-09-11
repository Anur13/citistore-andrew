package com.andrew.movieland.service;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.util.sorting.SortType;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();

    public List<Movie> getRandom(int randomMoviesQuantity);

    public List<Movie> findByGenre(int genreId);

    public List<Movie> getAllSorted(SortType sortType);

    public List<Movie> findByGenreAndSorted(SortType sortType, int genreId);
}
