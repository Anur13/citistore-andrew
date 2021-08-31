package com.andrew.movieLand.dao.jdbc;

import com.andrew.movieLand.dao.jdbc.mapper.MoviesRowMapper;
import com.andrew.movieLand.dao.MovieDao;
import com.andrew.movieLand.entity.Movie;
import lombok.AllArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@AllArgsConstructor
public class JdbcMovieDao implements MovieDao {
    private JdbcTemplate jdbcTemplate;
    private static final MoviesRowMapper moviesRowMapper = new MoviesRowMapper();

    private static final String GET_ALL_MOVIES_QUERY = "SELECT * FROM movies";

    @Override
    public List<Movie> getAllMovies() {
        return jdbcTemplate.query(GET_ALL_MOVIES_QUERY, moviesRowMapper);
    }
}
