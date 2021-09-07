package com.andrew.movieland.service;

import com.andrew.movieland.dao.GenreDao;
import com.andrew.movieland.entity.Genre;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@AllArgsConstructor
public class DefaultGenreService implements GenreService {

    private GenreDao genreDao;

    public List<Genre> findAll() {
        return genreDao.findAll();
    }
}
