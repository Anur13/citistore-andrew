package com.andrew.movieLand.service;

import com.andrew.movieLand.dao.jdbc.JdbcMovieDao;
import com.andrew.movieLand.entity.Movie;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Setter
public class MovieService {
    @Autowired
    JdbcMovieDao jdbcMovieDao;

    public List<Movie> getAllMovies(){
        return jdbcMovieDao.getAllMovies();
    }


}
