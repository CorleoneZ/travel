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
 * 用户打卡表
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_experience")
@Getter
@Setter
@SuperBuilder
public class UserExperience {

    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "city")
    private String city;

}
