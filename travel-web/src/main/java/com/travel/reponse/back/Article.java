package com.travel.reponse.back;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Getter
@Setter
@SuperBuilder
public class Article {

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("commentNumber")
    private int commentNumber;

    @JsonProperty("")
    private String content;

    @JsonProperty("dateAdd")
    private String dateAdd;

    @JsonProperty("dateUpdate")
    private String dateUpdate;

    @JsonProperty("descript")
    private String descript;

    @JsonProperty("extInfo")
    private List extInfo;

    @JsonProperty("hasTourJourney")
    private boolean hasTourJourney;

    @JsonProperty("id")
    private String id;

    @JsonProperty("isDraft")
    private boolean isDraft;

    @JsonProperty("isRecommend")
    private boolean isRecommend;

    @JsonProperty("keywords")
    private String keywords;

    @JsonProperty("numberFav")
    private int numberFav;

    @JsonProperty("paixu")
    private int paixu;

    @JsonProperty("pic")
    private String pic;

    @JsonProperty("status")
    private int status;

    @JsonProperty("statusStr")
    private String statusStr;

    @JsonProperty("title")
    private String title;

    @JsonProperty("uid")
    private int uid;

    @JsonProperty("unusefulNumber")
    private int unusefulNumber;

    @JsonProperty("usefulNumber")
    private int usefulNumber;

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("views")
    private int views;

}
