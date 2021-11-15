package com.travel.reponse.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Builder
@ApiModel("修改基本岑书")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateForm implements Serializable {

    @JsonProperty("Username")
    @NotNull
    private String username;

    @JsonProperty("Email")
    @NotNull
    private String email;

    @JsonProperty("Title")
    @NotNull
    private String title;

    @JsonProperty("Hobby")
    @NotNull
    private String hobby;

}
