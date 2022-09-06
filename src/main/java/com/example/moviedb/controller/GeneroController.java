package com.example.moviedb.controller;

import com.example.moviedb.entity.Genero;
import com.example.moviedb.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class GeneroController {

    @Autowired
    GeneroService generoService;
    @GetMapping("api/genero/movie/list")
    public List<Genero> getAllGenres() throws IOException {

       return generoService.findAllGenreMovieList();
    }
}
