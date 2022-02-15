package com.travel.reponse.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@ApiModel("文章请求接口参数")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class CategoryForm {

    @JsonProperty(value = "page")
    @NotNull
    private int page;

    @JsonProperty("categoryId")
    @NotNull
    private int categoryId;
}
