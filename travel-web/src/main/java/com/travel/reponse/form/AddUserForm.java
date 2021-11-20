package com.travel.reponse.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Getter
@Builder
@ApiModel("添加用户参数")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class AddUserForm implements Serializable {

    @JsonProperty(value = "Username")
    @NotNull
    private String username;

    @JsonProperty("Password")
    @NotNull
    private String password;

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
