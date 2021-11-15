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
 * city strategy
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_city_strategy")
@Getter
@Setter
@SuperBuilder
public class Strategy {

    @TableField(value = "id")
    @TableId
    private Long id;

    @TableField(value = "city")
    private String city;

    @TableField(value = "title")
    private String title;

    @TableField(value = "strategy")
    private String strategy;

    @TableField(value = "foods")
    private String foods;

    @TableField(value = "remark")
    private String remark;

    @TableField(value = "pop")
    private int pop;
}
