package com.example.moviedb.service;

import com.example.moviedb.entity.Cast;
import com.example.moviedb.entity.CastCrew;
import com.example.moviedb.entity.Crew;
import com.example.moviedb.entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

@Service
public class CastCrewService {
    final String Key = "db480a66e73e275109a44794db7efae1";
    final String uri = "https://api.themoviedb.org/3/";

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

    public CastCrew findCastCrew(Integer movie_id) throws IOException {
        StringBuilder jsonReq = getJson(uri+"movie/"+movie_id.toString()+"/credits?api_key="+Key);
        ObjectMapper mapper = new ObjectMapper();
        Cast[] responseCast  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("cast").toString(), Cast[].class);
        Crew[] responseCrew  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("crew").toString(),Crew[].class);
        CastCrew response = new CastCrew();
        response.setCasts(Arrays.asList(responseCast));
        response.setCrews(Arrays.asList(responseCrew));

        return response;
    }

}
