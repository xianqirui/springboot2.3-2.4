package com.example.bootweb01.conf;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean
    public WebMvcAutoConfiguration webMvcAutoConfiguration(){
        return null;
    }
}
