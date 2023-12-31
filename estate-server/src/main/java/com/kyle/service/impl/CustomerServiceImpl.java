package com.kyle.service.impl;

import com.kyle.mapper.CustomerMapper;
import com.kyle.service.CustomerService;
import com.kyle.entity.Customer;
import com.kyle.entity.LoginDTO;
import com.kyle.exception.AccountNotFoundException1;
import com.kyle.exception.PasswordErrorException;
import com.kyle.constant.MessageConstant;
import com.kyle.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public LoginVO login(LoginDTO loginDTO)  {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Customer customer = customerMapper.getByUsername(username);
        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (customer == null) {
            //账号不存在
            throw new AccountNotFoundException1(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
        if (!password.equals(customer.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        LoginVO loginVO = LoginVO.builder()
                .id(customer.getId())
                .userName(username)
                .name(customer.getName())
                .build();
        //3、返回实体对象
        return loginVO;
    }
}
