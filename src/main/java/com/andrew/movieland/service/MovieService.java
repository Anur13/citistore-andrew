package com.andrew.movieland.service;

import com.andrew.movieland.dao.MovieDao;
import com.andrew.movieland.entity.Genre;
import com.andrew.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class MovieService {
    @Autowired
    private MovieDao movieDao;
    private GenreService genreService;

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public List<Movie> getRandom(int randomQuantity) {
        return movieDao.getRandom(randomQuantity);
    }

    public List<Movie> findByGenre(int genreId) {
        Genre genre = genreService.findById(genreId);
        return movieDao.findByGenre(genre.getName());
    }

}
