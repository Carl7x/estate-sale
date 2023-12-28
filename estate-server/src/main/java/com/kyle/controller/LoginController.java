package com.kyle.controller;

import com.kyle.service.AdminService;
import com.kyle.dto.LoginDTO;
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
    private JwtProperties jwtProperties;

    @SneakyThrows
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO) {
        Integer role = loginDTO.getRole();
        //0为admin 1为customer
        String token = null;
        LoginVO tempVO = null;

             tempVO = adminService.login(loginDTO);
            Map<String, Object> claims = new HashMap<>();
            claims.put(tempVO.getUserName(), tempVO.getId());
            token = JwtUtil.createJWT(
                    jwtProperties.getAdminSecretKey(),
                    jwtProperties.getAdminTtl(),
                    claims);

        LoginVO loginVO = LoginVO.builder()
                .userName(tempVO.getUserName())
                .id(tempVO.getId())
                .token(token)
                .name(tempVO.getName())
                .build();

        return Result.success(loginVO);
    }

}
