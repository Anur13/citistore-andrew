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
    private static final MoviesRowMapper MOVIES_ROW_MAPPER = new MoviesRowMapper();
    private static final String GET_ALL_MOVIES_QUERY = "SELECT id, name_russian ,name_native," +
            " released_date, rating , price, picture_path FROM movies";

    private static final String GET_RANDOM_QUERY = "SELECT id, name_russian, name_native," +
            " released_date, rating, price, picture_path FROM" +
            " movies ORDER BY RANDOM() LIMIT ?;";

    private static final String GET_MOVIES_BY_GENRE_ID_QUERY = "select id, name_russian, name_native," +
            " released_date, rating, price, picture_path FROM movies LEFT JOIN movie_genre ON movie_genre.movie_id = movies.id " +
            "where movie_genre.genre_id = ?;";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getRandom(int randomMovieQuantity) {
        log.info("Requesting random {}", randomMovieQuantity);
        return jdbcTemplate.query(GET_RANDOM_QUERY, MOVIES_ROW_MAPPER, randomMovieQuantity);
    }

    @Override
    public List<Movie> findAll() {
        log.info("Requesting find all");
        return jdbcTemplate.query(GET_ALL_MOVIES_QUERY, MOVIES_ROW_MAPPER);
    }

    @Override
    public List<Movie> getMoviesByGenre(int genreId) {
        return jdbcTemplate.query(GET_MOVIES_BY_GENRE_ID_QUERY, MOVIES_ROW_MAPPER, genreId);
    }
}
