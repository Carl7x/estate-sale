package com.kyle.mapper;

import com.github.pagehelper.Page;
import com.kyle.annotation.AutoFill;
import com.kyle.dto.PropertyDTO;
import com.kyle.dto.PropertyPageQueryDTO;
import com.kyle.entity.Property;
import com.kyle.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface PropertyMapper {

    /**
     * 分页查询
     * @param propertyPageQueryDTO
     * @return
     */
    Page<Property> pageQuery(PropertyPageQueryDTO propertyPageQueryDTO);

    @Select("select * from table.property where id = #{id}")
    Property get(Integer id);
    @Insert("insert into `table`.property (name,area,price, description, img, type, create_time, update_time) " +
            "values " +
            "(#{name},#{area},#{price},#{description},#{img},#{type},#{createTime},#{updateTime})")
    @AutoFill(value = OperationType.INSERT)
    void create(Property property);
}
