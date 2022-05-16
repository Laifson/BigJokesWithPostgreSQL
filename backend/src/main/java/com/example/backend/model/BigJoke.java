package com.example.backend.model;

import com.example.backend.service.JsonConverter;
import lombok.*;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jokes_table")
public class BigJoke {

    @Id
    private Integer id;
    private Boolean safe;
    private Boolean error;
    private String category;
    private String type;
    private String joke;
    private String setup;
    private String delivery;
    private String lang;

    @Convert(converter = JsonConverter.class)
    private Flags flags;

}
