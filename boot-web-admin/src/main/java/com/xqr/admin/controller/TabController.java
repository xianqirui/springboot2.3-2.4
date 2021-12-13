package com.xqr.admin.controller;

import com.xqr.admin.bean.User;
import com.xqr.admin.exception.UserTooManyexception;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class TabController {

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        //表格遍历
        List<User> users = Arrays.asList(new User("zhanghsa", "123456"),
                new User("lisi", "123444"),
                new User("hah", "55555"),
                new User("hehe", "66666"));
        model.addAttribute("users",users);

        if(users.size()>3){
            throw new UserTooManyexception();
        }
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }
}
