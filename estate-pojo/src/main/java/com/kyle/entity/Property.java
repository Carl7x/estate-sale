package com.kyle.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.entity
 * @Project：estate-sales-management
 * @Date：2023/12/31 11:32
 * @Filename：Property
 */
@Data
public class Property implements Serializable {

    private Integer id;

    private String name;

    private Integer area;

    private Integer price;

    private String description;

    private String img;

    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
