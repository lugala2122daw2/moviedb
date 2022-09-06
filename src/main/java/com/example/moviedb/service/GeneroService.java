package com.example.moviedb.service;

import com.example.moviedb.entity.Genero;
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
public class GeneroService {
    final String uri = "https://api.themoviedb.org/3/";
    public List<Genero> findAllGenreMovieList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(uri+"genre/movie/list?api_key=db480a66e73e275109a44794db7efae1");

        InputStream input = url.openStream();
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder json = new StringBuilder();
        int c ;
        while((c= reader.read())!=-1){
            json.append((char)c);
        }

        Genero[] response  = mapper.readValue(mapper.readTree(json.toString()).get("genres").toString(),Genero[].class);

        return Arrays.asList(response);

    }
}
