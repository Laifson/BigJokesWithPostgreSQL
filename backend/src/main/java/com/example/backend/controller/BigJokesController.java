package controller;


import model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.BigJokesService;

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
