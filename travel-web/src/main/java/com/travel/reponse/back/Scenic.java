package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * return city pop scenic list
 */
@Data
@Getter
@Setter
@SuperBuilder
public class Scenic {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Detail")
    private String detail;

}
