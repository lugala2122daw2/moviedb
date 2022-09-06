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
    final String apiKey = "db480a66e73e275109a44794db7efae1";

    public List<Movie> findAllMovieList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(uri+"movie/popular?api_key="+apiKey);

        InputStream input = url.openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder json = new StringBuilder();
        int c ;
        while((c= reader.read())!=-1){
            json.append((char)c);
        }

        Movie[] response  = mapper.readValue(mapper.readTree(json.toString()).get("results").toString(),Movie[].class);

        return Arrays.asList(response);

    }


}
