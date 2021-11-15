package com.travel.reponse.back;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * return city strategy
 */
@Data
@Getter
@Setter
@SuperBuilder
public class CityStrategy {

    @JsonProperty("Name")
    private String name;

    @TableField("Title")
    private String title;

    @JsonProperty("Strategy")
    private String strategy;

    @JsonProperty("foods")
    private String foods;

    @JsonProperty("remark")
    private String remark;
}
