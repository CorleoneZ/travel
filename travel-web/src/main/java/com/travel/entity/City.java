package com.travel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 所有热门城市表
 */

@AllArgsConstructor
@NoArgsConstructor
@TableName("t_all_city")
@Getter
@Setter
@SuperBuilder
public class City {

    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("city_name")
    private String cityName;

    @TableField("detail")
    private String detail;

    @TableField("connection_city")
    private String connectionCity;

    @TableField("pop")
    private int pop;

}
