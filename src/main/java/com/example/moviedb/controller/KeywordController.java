package com.example.moviedb.controller;

import com.example.moviedb.entity.Keyword;
import com.example.moviedb.service.KeywordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class KeywordController {

    @GetMapping("api/movie/{movie_id}/keywords")
    public List<Keyword> findKeyword(@PathVariable Integer movie_id) throws IOException {
        KeywordService keywordService = new KeywordService();
        return keywordService.findKeyword(movie_id);
    }
}
