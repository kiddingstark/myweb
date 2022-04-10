package com.example.myweb.aspect;


import com.alibaba.fastjson.JSONObject;
import com.example.myweb.constant.LogConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 切面实用指定路径方式而不使用注解方式
     */
    @Pointcut("execution(public * com.example.myweb.controller..*.*(..)) ")
    private void pointcut() {
    }

    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        /**
         * 在方法执行之前MDC加入了生成的唯一id
         * 实现了鉴权功能后MDC中还可以加入userId唯一确认日志信息
         * 在logback-spring.xml中显示MDC
         */
        MDC.put(LogConstant.TRACE_ID_KEY, UUID.randomUUID().toString());
        //MDC.put("userId", "test");

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("url", request.getRequestURL());
        paramMap.put("httpMethod", request.getMethod());
        paramMap.put("method", joinPoint.getSignature());
        paramMap.put("args", Arrays.toString(joinPoint.getArgs()));
        log.info("request:{}", JSONObject.toJSONString(paramMap));
    }

    @AfterReturning(returning = "o", pointcut = "pointcut()")
    public void after(Object o) {
        log.info("Response: {}", JSONObject.toJSONString(o));
    }

}
