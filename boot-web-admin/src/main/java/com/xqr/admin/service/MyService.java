package com.xqr.admin.service;

import com.xqr.admin.bean.City;
import com.xqr.admin.bean.User01;

public interface MyService {
    public User01 selectbyid(Integer uid);
    public City getbyID(int id);
    public void saveCity(City city);

}
