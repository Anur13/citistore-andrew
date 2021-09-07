package com.andrew.movieland.dao.jdbc;

import com.andrew.movieland.dao.GenreDao;
import com.andrew.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.andrew.movieland.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class JdbcGenreDao implements GenreDao {
    
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private static final String FIND_ALL_QUERY = "SELECT id, name FROM genre;";

    private JdbcTemplate jdbcTemplate;

    public List<Genre> findAll() {
        log.info("Requesting all genres");
        return jdbcTemplate.query(FIND_ALL_QUERY, GENRE_ROW_MAPPER);
    }


}
