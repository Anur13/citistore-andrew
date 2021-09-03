package com.andrew.movieland.service;

import com.andrew.movieland.dao.MovieDao;
import com.andrew.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    public List<Movie> getThreeRandom() {
        return movieDao.getThreeRandom();
    }
}
