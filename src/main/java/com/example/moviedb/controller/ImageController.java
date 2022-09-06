package com.example.moviedb.controller;

import com.example.moviedb.entity.Image;
import com.example.moviedb.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;
    @GetMapping("api/movie/{movie_id}/images")
    public List<Image> getImageOfMovieById(@PathVariable Integer movie_id) throws IOException {
        return imageService.findAllImagesMovie(movie_id);
    }

}
