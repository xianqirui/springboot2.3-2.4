package com.xqr.admin.mapper;

import com.xqr.admin.bean.User01;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface AccountMapper {
    public User01 selectbyid(Integer uid);
}
