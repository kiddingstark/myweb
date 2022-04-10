package com.example.myweb.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{

    private Boolean success=false;

    private String code;

    private String msg;

    public BusinessException(String msg) {
        this.success=false;
        this.msg = msg;
    }

    public BusinessException(String code,String msg) {
        this.success=false;
        this.msg = msg;
        this.code = code;
    }
}
