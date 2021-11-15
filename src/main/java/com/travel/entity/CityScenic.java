package com.travel.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 城市景点表
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_city_scenic")
@Getter
@Setter
@SuperBuilder
public class CityScenic {

    @TableField(value = "id")
    @TableId
    private Long id;

    @TableField(value = "city")
    private String city;

    @TableField(value = "scenic")
    private String scenic;

    @TableField(value = "detail")
    private String detail;
}
