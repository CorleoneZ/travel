package com.travel.controller;

import com.travel.reponse.Result;
import com.travel.reponse.form.AddUserForm;
import com.travel.reponse.form.LoginForm;
import com.travel.reponse.form.UpdateForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户操作入口")
public interface UserController {

    @ApiOperation("注册用户")
    Result addUser(AddUserForm addUserForm);

    @ApiOperation("用户登陆")
    Result login(LoginForm loginForm);

    @ApiOperation("用户注销")
    Result logout();

    @ApiOperation("更新基本信息")
    Result updateMessage(UpdateForm updateForm);
}
