package com.example.backend.controller;

import com.example.backend.api.service.BigJokesApiService;
import com.example.backend.model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/search")
public class JokesApiController {

    private final BigJokesApiService bigJokesApiService;

    @Autowired
    public JokesApiController(BigJokesApiService bigJokesApiService) {
        this.bigJokesApiService = bigJokesApiService;
    }

    @GetMapping(value = {"", "{category}"})
    public List<BigJoke> getJoke(@PathVariable(required = false) String category, @RequestParam Optional<String> params) {
        return bigJokesApiService.filterEntries(Objects.requireNonNullElse(category, "any"), params);
    }

}
