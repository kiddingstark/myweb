package com.example.myweb.dto;

import lombok.Getter;

/**
 * @Author Eric
 * @Date 2020/12/21 16:36
 */
@Getter
public enum ResponseCode {

    /**
     * 请求成功
     */
    SUCCESS("200", "Success"),
    /**
     * 请求错误
     */
    BAD_REQUEST("400", "Bad Request"),
    /**
     * 请求超时
     */
    REQUEST_TIMEOUT("408", "Request Timeout"),
    /**
     * 权限问题
     */
    UNAUTHORIZED("401", "Unauthorized"),
    /**
     * 未知异常
     */
    ERROR("500", "Internal Server Error"),
    /**
     * 功能不支持
     */
    NOT_IMPLEMENTED("501", "Not Implemented"),
    /**
     * 服务异常
     */
    BAD_GATEWAY("502", "Bad Gateway"),
    /**
     * 临时异常
     */
    SERVICE_UNAVAILABLE("503", "Service Unavailable");

    private String code;
    private String msg;

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}


