package com.example.bootweb01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/success")
    public String hello(Model model){
        model.addAttribute("mgs","你好");
        model.addAttribute("link","https://www.baidu.com");
        return "success";
    }
}
