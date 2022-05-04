package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="jokesTable")
public class BigJoke {

    @Id
    private Integer id;
    private Boolean safe;
    private Boolean error;
    private String category;
    private String type;
    private String lang;

}
