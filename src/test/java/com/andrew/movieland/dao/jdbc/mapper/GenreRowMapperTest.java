package com.andrew.movieland.dao.jdbc.mapper;

import com.andrew.movieland.entity.Genre;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GenreRowMapperTest {

    @Test
    public void testGenreRowMapper() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("вестерн");

        GenreRowMapper genreRowMapper = new GenreRowMapper();
        Genre genre = genreRowMapper.mapRow(resultSet, 0);
        assertEquals(genre.getId(), 1);
        assertEquals(genre.getName(), "вестерн");
    }
}