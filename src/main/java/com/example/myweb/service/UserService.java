package com.example.myweb.service;

import com.example.myweb.dto.request.UserRequestDto;
import com.example.myweb.dto.response.UserResponseDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 7:25 下午
 */
public interface UserService {

    UserResponseDto login(UserRequestDto userRequestDto, HttpServletRequest request);
}
