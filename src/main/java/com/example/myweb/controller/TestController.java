package com.example.myweb.controller;

import com.example.myweb.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/logTest")
    public Response logTest(String param) {
        log.warn("日志测试打印");
        return Response.succeed();
    }

    @GetMapping("testRedis")
    public Response testRedis() {
        redisTemplate.opsForValue().set("test", "test");
        return Response.succeed();
    }


}
