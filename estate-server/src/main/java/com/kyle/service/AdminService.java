package com.kyle.service;

import com.kyle.entity.LoginDTO;
import com.kyle.vo.LoginVO;

public interface AdminService {
    public LoginVO login(LoginDTO loginDTO);
}
