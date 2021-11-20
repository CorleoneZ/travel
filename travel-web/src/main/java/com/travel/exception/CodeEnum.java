package com.travel.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 */
@AllArgsConstructor
@Getter
public enum CodeEnum {

    SUCCESS(200,"成功!"),
    PASSWORD_ERROR(300,"密码错误, 请重新输入密码!"),
    PARAM_ERROR(444,"请求参数错误!"),
    USER_NOT_EXIST(301,"登陆用户不存在"),
    USER_EXIST(302,"注册用户已经存在"),
    EMAIL_EXIST(303,"注册邮箱已经存在"),
    COMMON_ERROR(500,"通用错误")
    ;

    private final int code;
    private final String message;

}
