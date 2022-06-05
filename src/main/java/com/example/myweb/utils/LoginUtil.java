package com.example.myweb.utils;

import com.example.myweb.model.UserEntity;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 7:49 下午
 */
public class LoginUtil {

    public static HashMap<String, HttpSession> sessionHashMap = new HashMap<>();

    public static boolean putSession(String username, HttpSession session) {
        if (sessionHashMap.containsKey(username)
                && null != (sessionHashMap.get(username).getAttribute(UserEntity.USERNAME))) {
            HttpSession oldSession = sessionHashMap.get(username);
            //这里没有调用invalidate方法的话只是map中无旧session，但是旧session并没有失效，旧客户端仍可登录
            oldSession.invalidate();
        }
        sessionHashMap.put(username, session);
        return true;
    }
}
