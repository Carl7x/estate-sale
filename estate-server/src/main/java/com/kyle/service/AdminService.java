package com.kyle.service;

import com.kyle.dto.LoginDTO;
import com.kyle.vo.LoginVO;

import javax.security.auth.login.AccountNotFoundException;

public interface AdminService {
    public LoginVO login(LoginDTO loginDTO) throws AccountNotFoundException;
}
