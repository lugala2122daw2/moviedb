package com.example.moviedb.service;

import com.example.moviedb.entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {
    final String uri = "https://api.themoviedb.org/3/";
    final String Key = "db480a66e73e275109a44794db7efae1";

    private StringBuilder getJson(String url) throws IOException {
        InputStream input = new URL(url).openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder json = new StringBuilder();
        int a ;
        while((a= reader.read())!=-1){
            json.append((char)a);
        }
        return json;
    }

    //Find all movies
    public List<Movie> findAllMovieList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/popular?api_key="+Key;
        Movie[] response  = mapper.readValue(mapper.readTree(getJson(url).toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    //Find popular movies
    public List<Movie> findPopularMovies() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/popular?api_key="+Key;
        Movie[] response  = mapper.readValue(mapper.readTree(getJson(url).toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    //Find movie by Id
    public Movie findMovieById(Integer movie_id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/"+movie_id.toString()+"?api_key="+Key;
        Movie response  = mapper.readValue(mapper.readTree(getJson(url).toString()).toString(),Movie.class);
        return response;
    }

    //Find top rated movies
    public List<Movie> findTopRatedMovies() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/top_rated?api_key="+Key;
        Movie[] response  = mapper.readValue(mapper.readTree(getJson(url).toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    //Find recommendations
    public List<Movie> findRecommendations(Integer movie_id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/"+movie_id.toString()+"/recommendations?api_key="+Key;
        Movie[] response  = mapper.readValue(mapper.readTree(getJson(url).toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }

    //Find similar movies
    public List<Movie> findSimilarMovies(Integer movie_id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String url = uri+"movie/"+movie_id.toString()+"/similar?api_key="+Key;
        Movie[] response  = mapper.readValue(mapper.readTree(getJson(url).toString()).get("results").toString(),Movie[].class);
        return Arrays.asList(response);
    }


}
