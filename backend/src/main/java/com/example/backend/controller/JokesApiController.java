package controller;

import api.service.BigJokesApiService;
import model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class JokesApiController {

    private final BigJokesApiService bigJokesApiService;

    @Autowired
    public JokesApiController(BigJokesApiService bigJokesApiService) {
        this.bigJokesApiService = bigJokesApiService;
    }

    @GetMapping
    public List<BigJoke> getJoke(@RequestParam String params) {
        return bigJokesApiService.filterEntries(params);
    }

}
