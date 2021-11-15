package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.entity.Strategy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * return a random city
 */
@Data
@Getter
@Setter
@SuperBuilder
public class RandomCity {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Scenic")
    private List<Scenic> scenicList;

    public RandomCity() {

    }

    @JsonProperty("Strategy")
    private Strategy strategy;

    @JsonProperty("Connection")
    private String connection;



}
