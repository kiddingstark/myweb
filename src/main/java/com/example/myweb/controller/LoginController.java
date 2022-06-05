package com.example.myweb.controller;

import com.example.myweb.dto.Response;
import com.example.myweb.dto.request.UserRequestDto;
import com.example.myweb.dto.response.UserResponseDto;
import com.example.myweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 7:24 下午
 */

@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Response<UserResponseDto> login(String username, String password, HttpServletRequest request) {
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username(username)
                .password(password)
                .build();
        UserResponseDto userResponseDto = userService.login(userRequestDto, request);
        if (null == userResponseDto) {
            return Response.fail("密码不正确！");
        }
        return Response.succeed(userResponseDto);
    }

    @GetMapping("/index")
    public Response<String> index() {
        return Response.succeed("请先登录！");
    }
}
