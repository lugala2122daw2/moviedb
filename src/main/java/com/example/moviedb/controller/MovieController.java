package com.example.moviedb.controller;

import com.example.moviedb.entity.Movie;
import com.example.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("api/movie/popular")
    public List<Movie> getPopularMovies() throws IOException {
    return movieService.findPopularMovies();
    }

    @GetMapping("api/movie/top_rated")
    public List<Movie> getTopRatedMovies() throws IOException {
    return movieService.findTopRatedMovies();
    }

    //Find movie by Id
    @GetMapping("api/movie/{movie_id}")
    public Movie getMovieById(@PathVariable Integer movie_id) throws IOException {
    return movieService.findMovieById(movie_id);
    }

    //Find recommendations
    @GetMapping("api/movie/{movie_id}/recommendations")
    public List<Movie> getRecommendationsOfMovieById(@PathVariable Integer movie_id) throws IOException {
    return movieService.findRecommendations(movie_id);
    }

    //Find similar movies
    @GetMapping("api/movie/{movie_id}/similar")
    public List<Movie> getSimilarMoviesOfMovieById(@PathVariable Integer movie_id) throws IOException {
    return movieService.findSimilarMovies(movie_id);
    }
}
