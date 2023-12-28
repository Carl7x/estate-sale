package com.kyle.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    private String username;

    private String password;
    //用户角色：客户（1） or admin（0）
    private Integer role;

}
