package com.xqr.admin.controller;

import com.xqr.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("/sss")
    public String sss(){
        int i=10/0;
        return "login";
    }

    //登录页
    @RequestMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    //主页面
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName())&&"123456".equals(user.getPassword())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登陆成功，重定向，防止表单重新提交
            return "redirect:/main.html";
            }else{
            model.addAttribute("mgs","账号密码错误");
            return "login";
        }
    }
    //去mian页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
      /*  Object loginUser = session.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }else {
            model.addAttribute("mgs","没有登录");
            return "login";
        }*/
        return "main";
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }
}
