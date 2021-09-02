package com.andrew.movieland.dao.jdbc;

import com.andrew.movieland.dao.MovieDao;
import com.andrew.movieland.dao.jdbc.mapper.MoviesRowMapper;
import com.andrew.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class JdbcMovieDao implements MovieDao {
    private static final MoviesRowMapper moviesRowMapper = new MoviesRowMapper();
    private static final String GET_ALL_MOVIES_QUERY = "SELECT id, name_russian ,name_native," +
            " released_date, rating , price, picture_path FROM movies";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> findAll() {
        return jdbcTemplate.query(GET_ALL_MOVIES_QUERY, moviesRowMapper);
    }
}
