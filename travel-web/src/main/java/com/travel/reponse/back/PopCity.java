package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * return main city list entry
 */
@Data
@Getter
@Setter
@SuperBuilder
public class PopCity {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

}
