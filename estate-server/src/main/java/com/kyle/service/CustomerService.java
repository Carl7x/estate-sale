package com.kyle.service;

import com.kyle.entity.LoginDTO;
import com.kyle.vo.LoginVO;

import javax.security.auth.login.AccountNotFoundException;

public interface CustomerService {
    public LoginVO login(LoginDTO loginDTO) throws AccountNotFoundException;
}
