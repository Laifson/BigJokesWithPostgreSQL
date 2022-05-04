package model;

import lombok.Data;

@Data
public class Flags {

    private boolean nsfw;
    private boolean religious;
    private boolean political;
    private boolean racist;
    private boolean sexist;
    private boolean explicit;

}
