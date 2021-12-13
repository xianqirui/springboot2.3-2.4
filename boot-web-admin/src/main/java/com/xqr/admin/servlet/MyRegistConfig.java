package com.xqr.admin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myservlet(){
        Myservlet myservlet = new Myservlet();
        return new ServletRegistrationBean(myservlet,"/my","/my02");

    }

    @Bean
    public FilterRegistrationBean myfilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/my02"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean mylister(){
        MyservletContextLister myservletContextLister = new MyservletContextLister();
        return new ServletListenerRegistrationBean(myservletContextLister);
    }
}
