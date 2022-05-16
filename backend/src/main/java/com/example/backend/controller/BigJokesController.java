package com.example.backend.controller;


import com.example.backend.service.BigJokesService;
import com.example.backend.model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jokes")
public class BigJokesController {

    private final BigJokesService bigJokesService;

    @Autowired
    public BigJokesController(BigJokesService bigJokesService) {
        this.bigJokesService = bigJokesService;
    }

    @GetMapping
    public List<BigJoke> getAllJokes() {
        return bigJokesService.getAllJokes();
    }

    @PostMapping
    public BigJoke addJoke(@RequestBody BigJoke newJoke) {
        return bigJokesService.addNewJoke(newJoke);
    }

}
