package com.example.backend.repo;

import com.example.backend.model.BigJoke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigJokesRepo extends JpaRepository<BigJoke, Integer> {

}
