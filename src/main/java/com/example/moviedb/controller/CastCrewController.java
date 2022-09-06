package com.example.moviedb.controller;

import com.example.moviedb.entity.CastCrew;
import com.example.moviedb.service.CastCrewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CastCrewController {

    @GetMapping("api/movie/{movie_id}/credits")
    public CastCrew findCastCrew(@PathVariable Integer movie_id) throws IOException {
        CastCrewService castCrewService = new CastCrewService();
        return castCrewService.findCastCrew(movie_id);
    }
}
