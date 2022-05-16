package com.example.backend.api.service;

import com.example.backend.api.dto.JokesDto;
import com.example.backend.model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BigJokesApiService {

    private final RestTemplate restTemplate;
    private final BigJokesApiMapper bigJokesApiMapper;

    private static final String API_URL = "https://v2.jokeapi.dev/joke/";

    @Autowired
    public BigJokesApiService(RestTemplate restTemplate, BigJokesApiMapper bigJokesApiMapper) {
        this.restTemplate = restTemplate;
        this.bigJokesApiMapper = bigJokesApiMapper;
    }

    public String buildUri(String category, Optional<String> params) {
        if (params.isPresent()) {
            return API_URL + category + params;
        } else {
            return API_URL + category;
        }
    }

    public JokesDto getJoke(String category, Optional<String> params) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        ResponseEntity<JokesDto> responseEntity = restTemplate.exchange(
                buildUri(category, params),
                HttpMethod.GET,
                new HttpEntity<>(headers),
                JokesDto.class);

        if (responseEntity.getBody() == null) {
            throw new NoSuchElementException("Couldn't receive data from external API");
        }

        return responseEntity.getBody();
    }

    public List<BigJoke> filterEntries(String category, Optional<String> params) {
        return bigJokesApiMapper.mapToBigJoke(List.of(getJoke(category, params)));
    }

}
