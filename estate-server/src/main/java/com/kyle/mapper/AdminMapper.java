package com.kyle.mapper;

import com.kyle.entity.Admin;
import com.kyle.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from `table`.customer where username = #{username}")
    public Admin getByUsername(String username);
}
