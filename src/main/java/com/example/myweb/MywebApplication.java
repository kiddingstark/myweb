package com.example.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.mybatis.spring.annotation.MapperScan;


@RestController
@SpringBootApplication
@MapperScan(basePackages="com.example.myweb.mapper")
public class MywebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MywebApplication.class, args);
    }

}
