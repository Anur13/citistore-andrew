package com.andrew.movieland.service.cache;

import com.andrew.movieland.dao.GenreDao;
import com.andrew.movieland.entity.Genre;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collections;
import java.util.List;

@Slf4j
public class GenreCache {
    private static final int UPDATE_TIMER = 1000 * 60 * 60 * 4;

    private GenreDao genreDao;

    private List<Genre> genresList;

    public List<Genre> getGenresList() {
        return genresList;
    }

    public GenreCache(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Scheduled(fixedRate = UPDATE_TIMER)
    private void updateGenres() {
        log.info("Updating genre cache");
        genresList = Collections.synchronizedList(genreDao.findAll());
    }
}
