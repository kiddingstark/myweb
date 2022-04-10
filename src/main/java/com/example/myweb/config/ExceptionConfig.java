package com.example.myweb.config;

import com.example.myweb.handler.MyExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ExceptionConfig {

    @Bean
    public MyExceptionHandler webMvcExceptionHandler(){
        log.info("*************************MyExceptionHandler拦截器拦截器配置完成****************************");
        return new MyExceptionHandler();
    }
}


