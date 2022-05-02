package api.service;

import api.dto.JokesDto;
import model.BigJoke;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigJokesApiMapper {

    public List<BigJoke> mapToBigJoke(List<JokesDto> listOfApiJokes) {
        List<BigJoke> listOfJokes = new ArrayList<>();

        listOfApiJokes.forEach(e -> listOfJokes.add(
                BigJoke.builder()
                        .id(e.getId())
                        .safe(e.isSafe())
                        .error(e.isError())
                        .category(e.getCategory())
                        .type(e.getType())
                        .lang(e.getLang())
                        .build()
        ));

        return listOfJokes;

    }

}
