package com.example.backend.api.dto;

import com.example.backend.model.Flags;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JokesDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("safe")
    private boolean safe;
    @JsonProperty("category")
    private String category;
    @JsonProperty("type")
    private String type;
    @JsonProperty("joke")
    private String joke;
    @JsonProperty("setup")
    private String setup;
    @JsonProperty("delivery")
    private String delivery;
    @JsonProperty("flags")
    private Flags flags;
    @JsonProperty("lang")
    private String lang;

    // APIs error handling
    @JsonProperty("error")
    private boolean error;
    @JsonProperty("internalError")
    private boolean internalError;
    @JsonProperty("code")
    private int code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("causedBy")
    private List<String> causedBy;
    @JsonProperty("additionalInfo")
    private String additionalInfo;

}
