package com.example.myweb.dto;

import com.example.myweb.constant.LogConstant;
import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * @Author Eric
 * @Date 2020/12/21 15:49
 */
@Data
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -5258121901577797017L;

    private Boolean success = true;

    private String code;

    private T data;

    private String msg;

    private String traceId;

    public Response() {
    }

    public Response(Boolean success, String code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.traceId = MDC.get(LogConstant.TRACE_ID_KEY);
    }

    public Response(Boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.traceId = MDC.get(LogConstant.TRACE_ID_KEY);
    }

    public boolean isFailed() {
        return !ResponseCode.SUCCESS.getCode().equals(code);
    }

    public static <T> Response<T> of(Boolean success, String code, String msg) {
        return of(success, code, msg, null);
    }

    public static <T> Response<T> of(Boolean success, String code, String msg, T data) {
        return new Response<>(success, code, msg, data);
    }

    public static <T> Response<T> succeed() {
        return of(true, ResponseCode.SUCCESS.getCode(), null);
    }

    public static <T> Response<T> succeed(T data) {
        return of(true, ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static <T> Response<T> fail(String msg) {
        return of(false, ResponseCode.ERROR.getCode(), msg);
    }

    public static <T> Response<T> fail(String code, String msg) {
        return of(false, code, msg);
    }

}
