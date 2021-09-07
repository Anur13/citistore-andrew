package com.andrew.movieland.dao;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.util.sorting.SortType;

import java.util.List;

public interface MovieDao {

    public List<Movie> findAll();

    public List<Movie> getRandom(int randomQuantity);

    public List<Movie> getMoviesByGenre(int genreId);

    public List<Movie> getSortedMovies(SortType sortType);

    public List<Movie> findMoviesByGenreAndSorted(SortType sortType, int genreId);

}
