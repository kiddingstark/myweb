package com.example.myweb.handler;

import com.alibaba.fastjson.JSONObject;
import com.example.myweb.dto.Response;
import com.example.myweb.dto.ResponseCode;
import com.example.myweb.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ResponseBody
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handleException(Exception exception, HttpServletRequest request) {
        log.warn("http request exception, uri={}, args={},", request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()), exception);
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public Response handleException(ArithmeticException exception, HttpServletRequest request) {
        log.warn("http request exception, uri={}, args={},", request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()), exception);
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response handleException(BusinessException exception, HttpServletRequest request) {
        log.warn("http request BusinessException, uri={}, args={}", request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()), exception);
        return Response.fail(exception.getMsg());
    }

    @ExceptionHandler(value = SystemException.class)
    @ResponseBody
    public Response handleException(SystemException exception, HttpServletRequest request) {
        log.warn("http request BusinessException, uri={}, args={}", request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()), exception);
        return Response.fail(exception.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    @ResponseBody
    public Response handleException(MissingServletRequestParameterException exception, HttpServletRequest request) {
        log.warn("http request MissingServletRequestParameterException, uri={}, args={}", request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()), exception);
        return Response.fail(ResponseCode.BAD_REQUEST.getCode(), exception.getMessage());
    }

}
