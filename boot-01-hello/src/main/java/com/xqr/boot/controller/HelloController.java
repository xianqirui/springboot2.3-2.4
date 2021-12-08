package com.xqr.boot.controller;

import com.xqr.boot.bean.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j //日志
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
    @RequestMapping("/hhh")
    public String hhh(@RequestParam("name") String name){
        log.info("请求进来了");
        return name;
    }
}
