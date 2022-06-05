package com.example.myweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.myweb.dto.request.UserRequestDto;
import com.example.myweb.dto.response.UserResponseDto;
import com.example.myweb.mapper.UserDao;
import com.example.myweb.model.UserEntity;
import com.example.myweb.service.UserService;
import com.example.myweb.utils.LoginUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 7:26 下午
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserResponseDto login(UserRequestDto userRequestDto, HttpServletRequest request) {
        UserResponseDto userResponseDto = new UserResponseDto();
        UserEntity userEntity = userDao.selectOne(new QueryWrapper<UserEntity>()
                .eq("username", userRequestDto.getUsername())
                .eq("password", userRequestDto.getPassword()));
        if (null == userEntity) {
            return null;
        }
        BeanUtils.copyProperties(userEntity, userResponseDto);
        userResponseDto.setPassword(null);

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute(UserEntity.USERNAME, userResponseDto);
        LoginUtil.putSession(userResponseDto.getUsername(), currentSession);
        return userResponseDto;

    }
}
