package com.xqr.admin.controller;

import com.xqr.admin.bean.City;
import com.xqr.admin.bean.User;
import com.xqr.admin.bean.User01;
import com.xqr.admin.service.impl.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    MyServiceImpl myService;
    //mybatis测试
    @ResponseBody
    @GetMapping("/select")
    public User01 selectbtid(@RequestParam("uid") Integer uid){
        return myService.selectbyid(uid);
    }
    //纯注解
    @GetMapping("/city")
    @ResponseBody
    public City getbyID(@RequestParam("id") int id){
        return myService.getbyID(id);
    }
    //插入
    @PostMapping("/city")
    @ResponseBody
    public City saveCity(City city){
        myService.saveCity(city);
        return city;
    }
    //去表单页
    @RequestMapping("/form")
    public String from(){
        return "tablefrom";
    }
    //sql监控
    @ResponseBody
    @GetMapping("/sql")
    public String sql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user ", long.class);
        return aLong.toString();
    }

    @GetMapping("/sss")
    public String sss( @RequestParam("a") int a){
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
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s = operations.get("/main.html");
        String s1 = operations.get("/sql");
        model.addAttribute("maincount",s);
        model.addAttribute("sqlcount",s1);
        return "main";
    }

    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "login";
    }
}
