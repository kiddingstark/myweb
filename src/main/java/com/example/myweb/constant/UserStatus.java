package com.example.myweb.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: zhengruihong
 * @description
 * @date: 2022/7/1 1:00 上午
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserStatus {

    ACTIVE(0,"已激活"),
    NOT_ACTIVE(1,"已禁用");

    private Integer code;

    private String desc;



}
