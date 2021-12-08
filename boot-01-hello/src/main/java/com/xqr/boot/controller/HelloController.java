package com.xqr.boot.controller;

import com.xqr.boot.bean.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired Card card;

    @RequestMapping("/hello")
    public String Hello(){
        return "hello Spring boot";
    }

    @RequestMapping("/card")
    public Card card(){
        return card;
    }
}
