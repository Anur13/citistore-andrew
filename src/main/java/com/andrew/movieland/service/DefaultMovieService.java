package com.andrew.movieland.service;

import com.andrew.movieland.dao.MovieDao;
import com.andrew.movieland.entity.Genre;
import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.util.sorting.SortField;
import com.andrew.movieland.util.sorting.SortType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class DefaultMovieService implements MovieService {
    private MovieDao movieDao;

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public List<Movie> getRandom(int randomMoviesQuantity) {
        return movieDao.getRandom(randomMoviesQuantity);
    }

    public List<Movie> findByGenre(int genreId) {
        return movieDao.getMoviesByGenre(genreId);
    }

    @Override
    public List<Movie> getAllSorted(SortType sortType) {
        return movieDao.getSortedMovies(sortType);
    }

    @Override
    public List<Movie> findByGenreAndSorted(SortType sortType, int genreId) {
        return movieDao.findMoviesByGenreAndSorted(sortType, genreId);
    }


}
