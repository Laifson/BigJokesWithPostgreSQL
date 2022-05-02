package api.service;

import api.dto.JokesDto;
import model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BigJokesApiService {

    private final RestTemplate restTemplate;
    private final BigJokesApiMapper bigJokesApiMapper;

    private static final String API_URL = "https://v2.jokeapi.dev/joke/Programming";

    /*
    private static final String[] categories = {
            "/Any", "/Misc", "/Programming", "/Dark",
            "Pun", "Spooky", "Christmas"
    };
     */

    @Autowired
    public BigJokesApiService(RestTemplate restTemplate, BigJokesApiMapper bigJokesApiMapper) {
        this.restTemplate = restTemplate;
        this.bigJokesApiMapper = bigJokesApiMapper;
    }

    public JokesDto getJoke(String params) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        ResponseEntity<JokesDto> responseEntity = restTemplate.exchange(
                API_URL + params,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                JokesDto.class);

        if (responseEntity.getBody() == null) {
            throw new NoSuchElementException("Couldn't receive data from external API");
        }

        return responseEntity.getBody();
    }

    public List<BigJoke> filterEntries(String params) {
        return bigJokesApiMapper.mapToBigJoke(List.of(getJoke(params)));
    }


}
