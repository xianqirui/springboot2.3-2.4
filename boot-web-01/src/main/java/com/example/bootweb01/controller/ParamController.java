package com.example.bootweb01.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*注解测试*/
@RestController
public class ParamController {

    @GetMapping("/car/{id}/own/{muname}")
    public Map<String,Object> getCar(//路径变量
                                     @PathVariable("id") Integer id,
                                     @PathVariable("muname") String name,
                                     @PathVariable Map<String,Object> pv,
                                     //获取请求头
                                     @RequestHeader("User-Agent") String UserAgent,
                                     @RequestHeader Map<String,Object> mp,
                                     //获取参数
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inter")List<String> like,
                                     @RequestParam Map<String,Object> map2
                                     //Cook
                                     /*@CookieValue Cookie cookie*/

                                        ){
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("myname",name);
//        map.put("map",pv);
//        map.put("UserAgent",UserAgent);
//        map.put("mp",mp);
        map.put("age",age);
        map.put("inters",like);
        map.put("map2",map2);
        //map.put("ga",cookie);
        return map;
    }
}
