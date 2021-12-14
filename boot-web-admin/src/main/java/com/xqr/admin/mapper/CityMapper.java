package com.xqr.admin.mapper;

import com.xqr.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getbyID(int id);
    //标签写法和注解写法
    @Insert("insert into city(name,state,country) values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);
}
