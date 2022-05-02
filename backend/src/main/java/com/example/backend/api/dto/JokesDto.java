package api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JokesDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("safe")
    private boolean safe;
    @JsonProperty("error")
    private boolean error;
    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonProperty("lang")
    private String lang;

}
