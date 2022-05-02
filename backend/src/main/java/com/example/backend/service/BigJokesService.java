package service;

import model.BigJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.BigJokesRepo;

import java.util.List;

@Service
public class BigJokesService {

    private final BigJokesRepo bigJokesRepo;

    @Autowired
    public BigJokesService(BigJokesRepo bigJokesRepo) {
        this.bigJokesRepo = bigJokesRepo;
    }

    public List<BigJoke> getAllJokes() {
        return bigJokesRepo.findAll();
    }

    public BigJoke addNewJoke(BigJoke newJoke) {
        return bigJokesRepo.save(newJoke);
    }
}
