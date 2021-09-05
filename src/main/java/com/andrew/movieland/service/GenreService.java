package com.andrew.movieland.service;

import com.andrew.movieland.dao.GenreDao;
import com.andrew.movieland.entity.Genre;
import com.andrew.movieland.service.cache.GenreCache;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class GenreService {
    @Autowired
    private GenreDao genreDao;

    @Autowired
    private GenreCache genreCache;

    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    public Genre findById(int id) {
        return genreCache.getGenresList().get(id);
    }
}
