package com.andrew.movieland.dao.jdbc.mapper;

import com.andrew.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MoviesRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {

        int id = resultSet.getInt("id");
        String nameRussian = resultSet.getString("name_russian");
        String nameNative = resultSet.getString("name_native");
        LocalDateTime releaseDate = resultSet.getTimestamp("released_date").toLocalDateTime();
        double rating = resultSet.getDouble("rating");
        double price = resultSet.getDouble("price");
        String picturePath = resultSet.getString("picture_path");

        return Movie.builder()
                .id(id)
                .nameRussian(nameRussian)
                .nameNative(nameNative)
                .releasedDate(releaseDate)
                .rating(rating)
                .price(price)
                .picturePath(picturePath)
                .build();
    }
}
