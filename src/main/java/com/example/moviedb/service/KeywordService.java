package com.example.moviedb.service;


import com.example.moviedb.entity.Keyword;
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
public class KeywordService {

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

    public List<Keyword> findKeyword(Integer movie_id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonReq = getJson(uri+"movie/"+movie_id.toString()+"/keywords?api_key="+Key);
        Keyword[] response  = mapper.readValue(mapper.readTree(jsonReq.toString()).get("keywords").toString(), Keyword[].class);
        return Arrays.asList(response);
    }
}
