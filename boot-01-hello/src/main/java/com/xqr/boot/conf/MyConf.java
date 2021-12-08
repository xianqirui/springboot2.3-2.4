package com.xqr.boot.conf;

import com.xqr.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类
public class MyConf {

    @Bean
    public User user01(){
        return new User("张三",15);
    }
}
