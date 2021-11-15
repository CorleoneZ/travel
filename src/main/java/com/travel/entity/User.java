package com.travel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * 用户表
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
@Getter
@Setter
@SuperBuilder
public class User {

    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;

    @TableField(value = "email")
    private String email;

    @TableField(value = "title")
    private String title;

    @TableField(value = "hobby")
    private String hobby;
}