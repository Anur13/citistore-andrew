package com.andrew.movieLand.dao.jdbc.mapper;

import com.andrew.movieLand.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MoviesRowMapper implements RowMapper {
    public Movie mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String nameRussian = resultSet.getString("name_russian");
        String nameNative = resultSet.getString("name_native");
        LocalDateTime releaseDate = resultSet.getTimestamp("released_date").toLocalDateTime();
        String description = resultSet.getString("description");
        double rating = resultSet.getDouble("rating");
        double price = resultSet.getDouble("price");
        String picturePath = resultSet.getString("picture_path");
        int votes = resultSet.getInt("votes");

        return Movie.builder()
                .id(id)
                .nameRussian(nameRussian)
                .nameNative(nameNative)
                .releasedDate(releaseDate)
                .description(description)
                .rating(rating)
                .price(price)
                .picturePath(picturePath)
                .votes(votes)
                .build();
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }
}
