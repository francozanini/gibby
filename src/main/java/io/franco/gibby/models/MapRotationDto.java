package io.franco.gibby.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class MapRotationDto{
    @JsonProperty("battle_royale")
    private GameMode battleRoyale;
    private GameMode arenas;
    private GameMode ranked;
    private GameMode arenasRanked;
}

