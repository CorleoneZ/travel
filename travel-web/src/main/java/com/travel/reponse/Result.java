package com.travel.reponse;

import com.travel.exception.CodeEnum;
import lombok.Getter;

import java.io.Serializable;

/**
 * 返回类型
 */

@Getter
public class Result implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public Result(String msg, String data) {
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public Result(CodeEnum codeEnum,Object data) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMessage();
        this.data = data;
    }

    public Result(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMessage();
    }

    public static Result success(CodeEnum codeEnum, Object data) {
        return new Result(codeEnum,data);
    }

    public static Result success(CodeEnum codeEnum) {
        return new Result(codeEnum);
    }

    public static Result fail(CodeEnum codeEnum) {
        return new Result(codeEnum);
    }
}
