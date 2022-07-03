package com.example.myweb.utils;

import com.example.myweb.exception.BusinessException;

/**
 * @author: zhengruihong
 * @description
 * @date: 2022/7/1 1:06 上午
 */
public class AssertUtil {

    public static void bussinessExceptionValidate(boolean flag, String msg) {
        if (flag) {
            throw new BusinessException(msg);
        }
    }

    public static void bussinessExceptionValidate(boolean flag, String code, String msg) {
        if (flag) {
            throw new BusinessException(code, msg);
        }
    }
}
