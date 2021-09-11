package com.andrew.movieland.web.controller;

import com.andrew.movieland.entity.Movie;
import com.andrew.movieland.service.DefaultMovieService;
import com.andrew.movieland.util.sorting.AcceptedSortTypesList;
import com.andrew.movieland.util.sorting.SortDirections;
import com.andrew.movieland.util.sorting.SortField;
import com.andrew.movieland.util.sorting.SortType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movie")
@Slf4j
public class MovieController {
    private DefaultMovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        log.info("Requesting find all");
        return movieService.findAll();
    }

    @GetMapping("/random")
    public List<Movie> findRandom(@RequestParam(defaultValue = "5") int randomMovieSQuantity) {
        log.info("Requesting random");
        return movieService.getRandom(randomMovieSQuantity);
    }

    @GetMapping("/genre/{genreId}")
    public List<Movie> findByGenre(@PathVariable int genreId) {
        return movieService.findByGenre(genreId);
    }

    @GetMapping(params = "rating")
    public List<Movie> getSortedMoviesByRating(@RequestParam("rating") String ratingDirection, HttpServletResponse httpServletResponse) throws IOException {
        SortType sortType = new SortType(SortDirections.valueOf(ratingDirection.toUpperCase()), SortField.RATING);
        if (AcceptedSortTypesList.ACCEPTED_SORT_TYPES.contains(sortType)) {
            return movieService.getAllSorted(sortType);
        }
        httpServletResponse.sendError(400, "Unacceptable sorting method");
        return null;
    }

    @GetMapping(params = "price")
    public List<Movie> getSortedMoviesByPrice(@RequestParam("price") String ratingDirection, HttpServletResponse httpServletResponse) throws IOException {
        SortType sortType = new SortType(SortDirections.valueOf(ratingDirection.toUpperCase()), SortField.PRICE);
        if (AcceptedSortTypesList.ACCEPTED_SORT_TYPES.contains(sortType)) {
            return movieService.getAllSorted(sortType);
        }
        httpServletResponse.sendError(400, "Unacceptable sorting method");
        return null;
    }

    @GetMapping(path = "/genre/{genreId}", params = "rating")
    public List<Movie> findMoviesByGenreAndSortedByRating(@RequestParam("rating") String ratingDirection, @PathVariable int genreId
            , HttpServletResponse httpServletResponse) throws IOException {
        SortType sortType = new SortType(SortDirections.valueOf(ratingDirection.toUpperCase()), SortField.RATING);
        if (AcceptedSortTypesList.ACCEPTED_SORT_TYPES.contains(sortType)) {
            return movieService.getAllSorted(sortType);
        }
        httpServletResponse.sendError(400, "Unacceptable sorting method");
        return null;
    }

    @GetMapping(path = "/genre/{genreId}", params = "price")
    public List<Movie> findMoviesByGenreAndSortedByPrice(@RequestParam("price") String ratingDirection, @PathVariable int genreId,
                                                         HttpServletResponse httpServletResponse) throws IOException {
        SortType sortType = new SortType(SortDirections.valueOf(ratingDirection.toUpperCase()), SortField.PRICE);
        if (AcceptedSortTypesList.ACCEPTED_SORT_TYPES.contains(sortType)) {
            return movieService.getAllSorted(sortType);
        }
        httpServletResponse.sendError(400, "Unacceptable sorting method");
        return null;
    }
    

}

