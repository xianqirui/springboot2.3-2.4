package com.xqr.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xqr.admin.bean.User;
import com.xqr.admin.exception.UserTooManyexception;
import com.xqr.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class TabController {
    @Resource
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";
    }
    //删除用户
    @GetMapping("/user/delect/{id}")
    public String delectUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes rs){
            userService.removeById(id);
            rs.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
      /*  //表格遍历
        List<User> users = Arrays.asList(new User("zhanghsa", "123456"),
                new User("lisi", "123444"),
                new User("hah", "55555"),
                new User("hehe", "66666"));
        model.addAttribute("users",users);

        if(users.size()>3){
            throw new UserTooManyexception();
        }*/
        //从数据库中查询user表中的用户
        List<User> users = userService.list();

//        model.addAttribute("users",users);
        //分页查询
        Page<User> page = new Page<>(pn, 2);
        Page<User> userPage = userService.page(page, null);
        long current = userPage.getCurrent();
        long pages = userPage.getPages();
        long total = userPage.getTotal();
        //获取用户信息
        List<User> records = userPage.getRecords();

        model.addAttribute("userPage",userPage);
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
