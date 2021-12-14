package com.xqr.admin.service.impl;

import com.xqr.admin.bean.City;
import com.xqr.admin.bean.User01;
import com.xqr.admin.mapper.AccountMapper;
import com.xqr.admin.mapper.CityMapper;
import com.xqr.admin.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Service
public class MyServiceImpl implements MyService {
    @Resource
    AccountMapper accountMapper;
    @Resource
    CityMapper cityMapper;

    public User01 selectbyid(Integer uid){
            return  accountMapper.selectbyid(uid);
    }
    //注解测试
    public City getbyID(int id){
        return cityMapper.getbyID(id);
    }
    @ResponseBody
    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
