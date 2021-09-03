package com.andrew.movieland.dao.jdbc;

import com.andrew.movieland.dao.MovieDao;
import com.andrew.movieland.dao.jdbc.mapper.MoviesRowMapper;
import com.andrew.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class JdbcMovieDao implements MovieDao {
    private static final MoviesRowMapper moviesRowMapper = new MoviesRowMapper();
    private static final String GET_ALL_MOVIES_QUERY = "SELECT id, name_russian ,name_native," +
            " released_date, rating , price, picture_path FROM movies";

    private static final String GET_THREE_RANDOM_QUERY = "SELECT id, name_russian, name_native," +
            " released_date, rating, price, picture_path FROM" +
            " movies ORDER BY RANDOM() LIMIT ?;";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getThreeRandom(int randomQuantity) {
        log.info("Requesting random {}", randomQuantity);
        return jdbcTemplate.query(GET_THREE_RANDOM_QUERY, moviesRowMapper, randomQuantity);
    }

    @Override
    public List<Movie> findAll() {
        log.info("Requesting find all");
        return jdbcTemplate.query(GET_ALL_MOVIES_QUERY, moviesRowMapper);
    }
}
