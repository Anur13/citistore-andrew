package com.andrew.movieland.dao.jdbc.mapper;

import com.andrew.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return Genre.builder()
                .id(id)
                .name(name)
                .build();
    }
}
