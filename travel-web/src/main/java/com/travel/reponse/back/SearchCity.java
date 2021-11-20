package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * return city detail by search
 */
@Data
@Getter
@Setter
@SuperBuilder
public class SearchCity {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Detail")
    private String detail;

    @JsonProperty("ScenicList")
    private List<Scenic> scenicList;
}
