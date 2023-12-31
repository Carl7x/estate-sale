package com.kyle.controller;

import com.kyle.dto.PropertyDTO;
import com.kyle.dto.PropertyPageQueryDTO;
import com.kyle.entity.Property;
import com.kyle.result.PageResult;
import com.kyle.result.Result;
import com.kyle.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.controller
 * @Project：estate-sales-management
 * @Date：2023/12/31 11:22
 * @Filename：EstateInfoController
 */
@RestController
@RequestMapping("/estate/property")
@Slf4j
public class EstateController {

    private PropertyService propertyService;

    public EstateController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/page")
    public Result<PageResult> page(PropertyPageQueryDTO propertyPageQueryDTO) {
        log.info("查询房产信息：{}", propertyPageQueryDTO);
        PageResult pageResult = propertyService.pageQuery(propertyPageQueryDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/get")
    public Result<Property> get(Integer id){
        Property property = propertyService.get(id);
        return Result.success(property);
    }

    @PostMapping
    public Result createEstate(@RequestBody PropertyDTO propertyDTO){
        log.info("新增房屋信息：{}",propertyDTO);
        propertyService.create(propertyDTO);
        return Result.success();
    }
}
