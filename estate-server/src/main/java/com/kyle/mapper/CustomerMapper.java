package com.kyle.mapper;

import com.kyle.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {

    @Select("select * from `table`.customer where username = #{username}")
    public Customer getByUsername(String username);
}
