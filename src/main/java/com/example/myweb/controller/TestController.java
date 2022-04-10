package com.example.myweb.controller;

import com.example.myweb.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/logTest")
    public Response logTest(String param) {
        log.warn("日志测试打印");
        int i = 1;
        int j = 0;
        System.out.println(i/j);
        return Response.succeed();
    }

}
