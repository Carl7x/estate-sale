package com.kyle.controller;

import com.kyle.service.AdminService;
import com.kyle.service.CustomerService;
import com.kyle.entity.LoginDTO;
import com.kyle.properties.JwtProperties;
import com.kyle.result.Result;
import com.kyle.utils.JwtUtil;
import com.kyle.vo.LoginVO;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;*/
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @Author: kyle
 * @CreateTime: 2023-12-17 12：42
 */

@RestController
@RequestMapping("/estate")
@Slf4j
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JwtProperties jwtProperties;

    @SneakyThrows
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        Integer role = loginDTO.getRole();
        //0为admin 1为customer
        String token = null;
        LoginVO tempVO = null;
        if (role == 1) {
             tempVO = customerService.login(loginDTO);
            Map<String, Object> claims = new HashMap<>();
            claims.put(tempVO.getUserName(), tempVO.getId());
            token = JwtUtil.createJWT(
                    jwtProperties.getAdminSecretKey(),
                    jwtProperties.getAdminTtl(),
                    claims);
        } else if (role == 0) {
            adminService.login(loginDTO);
        }
        LoginVO loginVO = LoginVO.builder()
                .userName(tempVO.getUserName())
                .id(tempVO.getId())
                .token(token)
                .name(tempVO.getName())
                .build();

        return Result.success(loginVO);
    }

}
