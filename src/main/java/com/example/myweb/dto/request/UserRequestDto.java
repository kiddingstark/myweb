package com.example.myweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhengruihong
 * @description: TODO
 * @date: 2022/6/4 7:27 下午
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String username;

    private String password;
}
