package com.travel.controller.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.travel.controller.UserController;
import com.travel.entity.User;
import com.travel.exception.CodeEnum;
import com.travel.orm.mapper.UserMapper;
import com.travel.reponse.Result;
import com.travel.reponse.form.AddUserForm;
import com.travel.reponse.form.LoginForm;
import com.travel.reponse.form.UpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserMapper userMapper;

    @Override
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public Result addUser(@RequestBody AddUserForm addUserForm) {
        //System.out.println("start......");

        //if username or email exist
        User name = userMapper.selectOne(new QueryWrapper<User>().eq("name", addUserForm.getUsername()));
        if (name != null) {
            return Result.fail(CodeEnum.USER_EXIST);
        }

        //add username
        User user = User.builder()
                .name(addUserForm.getUsername())
                .password(addUserForm.getPassword())
                .email(addUserForm.getEmail())
                .title(addUserForm.getTitle())
                .hobby(addUserForm.getHobby())
                .build();
        userMapper.insert(user);
        return Result.success(CodeEnum.SUCCESS,"register new user success!");
    }

    @Override
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody LoginForm loginForm) {
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("name",loginForm.getUsername()));
            if (!user.getPassword().equals(loginForm.getPassword())) {
                return Result.fail(CodeEnum.PASSWORD_ERROR);
            } else {

                return Result.success(CodeEnum.SUCCESS, user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.fail(CodeEnum.USER_NOT_EXIST);
        }
    }

    @Override
    public Result logout() {
        return null;
    }

    @Override
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Result updateMessage(@RequestBody UpdateForm updateForm) {
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("name", updateForm.getUsername()));
            String email = updateForm.getEmail();
            String title = updateForm.getTitle();;
            String hobby = updateForm.getHobby();
            user.setEmail(email);
            user.setTitle(title);
            user.setHobby(hobby);
            userMapper.updateById(user);
            return Result.success(CodeEnum.SUCCESS);
        } catch (Exception e) {
            return Result.fail(CodeEnum.COMMON_ERROR);
        }
    }
}
