package com.travel.controller.testController;

import com.travel.orm.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisDao redisDao;

    @RequestMapping("/helloredis")
    @ResponseBody
    public String hello(String name, String age) {
        redisDao.setKey("name", name);
        redisDao.setKey("age", age);

        System.out.println("name=" + name + " * " + "age=" + age);

        String retName = redisDao.getValue("name");
        String retAge = redisDao.getValue("age");
        return retName + " * " + retAge;
    }
}
