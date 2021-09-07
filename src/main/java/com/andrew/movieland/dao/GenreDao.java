package com.andrew.movieland.dao;

import com.andrew.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    public List<Genre> findAll();

}
