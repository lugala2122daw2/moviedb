package com.example.moviedb.controller;

import com.example.moviedb.entity.Movie;
import com.example.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    private static final String endpoint = "https://api.themoviedb.org/3/";

    @GetMapping("api/movie/list")
    public List<Movie> getAllMovies() throws IOException {
    return movieService.findAllMovieList();
    }

}
