package com.example.myweb.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class UserEntity {

    private int id;

    private String username;

    private String password;

    public static String USERNAME = "username";
    public static String PASSWORD = "password";


}
