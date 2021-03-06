package com.xqr.admin.conf;

import com.xqr.admin.interceptor.LoginInterceptor;
import com.xqr.admin.interceptor.RedisUrlCount;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/*
* 1.编写一个拦截器
* 2.把拦截器注册到容器中
* 3.注意静态资源的拦截
* */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    RedisUrlCount redisUrlCount;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor())
               .addPathPatterns("/**")  //所有请求都别拦截，包括静态资源
               .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**","/form");
       registry.addInterceptor(redisUrlCount)
               .addPathPatterns("/**")
               .excludePathPatterns("/","/login","/css/**","/js/**","/images/**","/fonts/**","/form");
    }



}
