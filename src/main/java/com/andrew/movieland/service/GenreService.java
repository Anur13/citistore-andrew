package com.andrew.movieland.service;

import com.andrew.movieland.entity.Genre;
import com.andrew.movieland.service.cache.GenreCache;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class GenreService {


    private GenreCache genreCache;

    public List<Genre> findAll() {
        return genreCache.getGenresList();
    }

    public Genre findById(int id) {
        return genreCache.getGenresList().get(id);
    }
}
