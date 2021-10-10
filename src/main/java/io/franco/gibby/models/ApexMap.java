package io.franco.gibby.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class ApexMap {
    private Integer start;
    private Integer end;
    @JsonProperty("readableDate_start")
    private String readableDateStart;
    @JsonProperty("readableDate_end")
    private String readableDateEnd;
    private String map;
    private String code;
    @JsonProperty("DurationInSecs")
    private Integer durationInSecs;
    @JsonProperty("DurationInMinutes")
    private Integer durationInMinutes;
    private String asset;
    private Integer remainingSecs;
    private Integer remainingMins;
    private String remainingTimer;
}
