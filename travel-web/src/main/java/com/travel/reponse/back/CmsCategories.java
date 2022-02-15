package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@SuperBuilder
public class CmsCategories {

    @JsonProperty("id")
    private int id;

    @JsonProperty("isUse")
    private boolean isUse;

    @JsonProperty("level")
    private int level;

    @JsonProperty("name")
    private String name;

    @JsonProperty("paixu")
    private int paixu;

    @JsonProperty("pid")
    private int pid;

    @JsonProperty("shopId")
    private int shopId;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("key")
    private String key;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("type")
    private String type;

    @JsonProperty("pids")
    private String pids;

}
