package com.andrew.movieland.dao;

import com.andrew.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    public List<Genre> findAll();

    public Genre findById(int id);
}
