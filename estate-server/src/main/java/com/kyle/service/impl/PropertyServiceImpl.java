package com.kyle.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kyle.constant.MessageConstant;
import com.kyle.dto.LoginDTO;
import com.kyle.dto.PropertyDTO;
import com.kyle.dto.PropertyPageQueryDTO;
import com.kyle.entity.Admin;
import com.kyle.entity.Property;
import com.kyle.exception.AccountNotFoundException1;
import com.kyle.exception.PasswordErrorException;
import com.kyle.mapper.AdminMapper;
import com.kyle.mapper.PropertyMapper;
import com.kyle.result.PageResult;
import com.kyle.service.AdminService;
import com.kyle.service.PropertyService;
import com.kyle.vo.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

@Autowired
private PropertyMapper propertyMapper;
    @Override
    public PageResult pageQuery(PropertyPageQueryDTO propertyPageQueryDTO) {
        PageHelper.startPage(propertyPageQueryDTO.getPage(), propertyPageQueryDTO.getPageSize());
        System.out.println(propertyPageQueryDTO.getPage());
        System.out.println(propertyPageQueryDTO.getPageSize());
        Page<Property> page = propertyMapper.pageQuery(propertyPageQueryDTO);
        long total = page.getTotal();
        List<Property> records = page.getResult();
        return new PageResult(total, records);
    }

    @Override
    public Property get(Integer id) {
        return propertyMapper.get(id);
    }

    /**
     * 新增房屋信息
     * @param propertyDTO
     */
    @Override
    public void create(PropertyDTO propertyDTO) {
        Property property = new Property();
        BeanUtils.copyProperties(propertyDTO,property);
        propertyMapper.create(property);
    }
}
