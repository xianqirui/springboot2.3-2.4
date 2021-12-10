package com.example.bootweb01.controller;

import com.example.bootweb01.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseController {

    @ResponseBody //利用返回值处理器，消息转化器处理
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAgr(18);
        person.setName("张三");
        person.setDate(new Date());
        return person;
    }
}
