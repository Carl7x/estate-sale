package com.kyle.entity;

import lombok.Data;

@Data
public class LoginDTO {

    private String username;

    private String password;
    //用户角色：客户（1） or admin（0）
    private Integer role;

}
