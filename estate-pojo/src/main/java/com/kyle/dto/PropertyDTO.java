package com.kyle.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.dto
 * @Project：estate-sales-management
 * @Date：2023/12/31 13:06
 * @Filename：PropertyDTO
 */
@Data
public class PropertyDTO implements Serializable {
    private Integer id;

    private String name;

    private Integer area;

    private Integer price;

    private String description;

    private String img;

    private String type;
}
