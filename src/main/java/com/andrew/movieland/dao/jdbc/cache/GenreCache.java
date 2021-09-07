package com.andrew.movieland.dao.jdbc.cache;

import com.andrew.movieland.dao.GenreDao;
import com.andrew.movieland.entity.Genre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GenreCache implements GenreDao {

    private final GenreDao genreDao;

    private List<Genre> cachedGenresList;

    @Scheduled(fixedDelayString = "${cache.timer}")
    private void updateGenres() {
        log.info("Updating genre cache");
        cachedGenresList = genreDao.findAll();
    }

    @Override
    public List<Genre> findAll() {
        return new ArrayList<>(cachedGenresList);
    }
}
