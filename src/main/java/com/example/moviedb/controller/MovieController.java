package com.example.moviedb.controller;

import com.example.moviedb.entity.Movie;
import com.example.moviedb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

@RestController
public class MovieController {

    private static final String INSERT_USERS_SQL = "INSERT INTO user_movies" +
            "  (userid , movieid , favorite , personal_rating , notes ) VALUES " +
            " (?, ?, ?, ?, ?);";

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

    @PatchMapping("api/movie/{movie_id}")
    public void updateMovie(@PathVariable Integer movie_id) throws IOException {
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/bbdd?useSSL=false", "root", "fjeclot");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 320);
            preparedStatement.setInt(2, movie_id);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setInt(4, 9);
            preparedStatement.setString(5, "Esta peli ha sido de las mejores que he visto nunca");
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
