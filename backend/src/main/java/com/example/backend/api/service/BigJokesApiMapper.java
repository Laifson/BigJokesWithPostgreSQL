package com.example.backend.api.service;

import com.example.backend.api.dto.JokesDto;
import com.example.backend.api.exception.JokesApiException;
import com.example.backend.model.BigJoke;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigJokesApiMapper {

    public List<BigJoke> mapToBigJoke(List<JokesDto> listOfApiJokes) {
        List<BigJoke> listOfJokes = new ArrayList<>();

        if (listOfApiJokes.get(0).isError()) {
            try {
                throw new JokesApiException(
                                "Error Code: " + listOfApiJokes.get(0).getCode() +
                                ". Internal Error: " + listOfApiJokes.get(0).isInternalError() +
                                ". Error Message: " + listOfApiJokes.get(0).getMessage() +
                                ". Error caused by: " + listOfApiJokes.get(0).getCausedBy() +
                                ". Additional infos: " + listOfApiJokes.get(0).getAdditionalInfo()
                );
            } catch (JokesApiException e) {
                e.printStackTrace();
            }
        } else {
            listOfApiJokes.forEach(e -> listOfJokes.add(
                    BigJoke.builder()
                            .id(e.getId())
                            .safe(e.isSafe())
                            .error(e.isError())
                            .category(e.getCategory())
                            .type(e.getType())
                            .joke(e.getJoke())
                            .setup(e.getSetup())
                            .delivery(e.getDelivery())
                            .lang(e.getLang())
                            .flags(e.getFlags())
                            .build()
            ));
        }
        return listOfJokes;
    }
}
