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
public class CmsArticles {

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("commentNumber")
    private int commentNumber;

    @JsonProperty("dateAdd")
    private String dateAdd;

    @JsonProperty("dateUpdate")
    private String dateUpdate;

    @JsonProperty("descript")
    private String descript;

    @JsonProperty("hasTourJourney")
    private boolean hasTourJourney;

    @JsonProperty("id")
    private int id;

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
