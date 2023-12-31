package com.kyle.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.dto
 * @Project：estate-sales-management
 * @Date：2023/12/31 11:36
 * @Filename：PropertyDTO
 */
@Data
public class PropertyPageQueryDTO implements Serializable {
    private int id;

    private String name;

    private int  area;

    private int price;

    private String img;

    private String type;
    //页码
    private int page;

    //每页显示记录数
    private int pageSize;
}
