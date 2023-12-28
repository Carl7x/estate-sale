package com.kyle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String name;
}
