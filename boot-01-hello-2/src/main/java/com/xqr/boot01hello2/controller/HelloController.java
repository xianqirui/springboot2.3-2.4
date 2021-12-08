package com.xqr.boot01hello2.controller;

import com.xqr.boot01hello2.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
