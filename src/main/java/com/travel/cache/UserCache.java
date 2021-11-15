package com.travel.cache;

import java.util.HashMap;

/**
 * 抛弃session，自己在服务端维护一个会话
 * 1. 记录用户信息
 * 2. 用户url地址拦截
 * 3. 方便多个使用同一个账户
 * 负载, 分布式情况下不适用, 可使用redis实现会话信息共享
 * */
public class UserCache {

    private static HashMap<String, Object> userMap = new HashMap<>();

    /**
     * 用户登陆
     * 放入缓存 username， password
     */
    public static void login(String username, String password) {
        userMap.put(username, password);
    }

    /**
     * 用户注销
     */
    public static void logout(String username) {
        userMap.remove(username);
    }

    /**
     * 获取用户信息
     */
    public static Object get(String username) {
        return userMap.get(username);
    }

    /**
     * key是否存在
     */
    public static boolean isExist(String key) {
        return userMap.containsKey(key);
    }
}
