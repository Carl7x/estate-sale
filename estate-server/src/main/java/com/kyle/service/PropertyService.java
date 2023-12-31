package com.kyle.service;

import com.kyle.dto.LoginDTO;
import com.kyle.dto.PropertyDTO;
import com.kyle.dto.PropertyPageQueryDTO;
import com.kyle.entity.Property;
import com.kyle.result.PageResult;
import com.kyle.vo.LoginVO;

import javax.security.auth.login.AccountNotFoundException;

public interface PropertyService {

    PageResult pageQuery(PropertyPageQueryDTO propertyPageQueryDTO);
    Property get(Integer id);

    void create(PropertyDTO propertyDTO);
}
