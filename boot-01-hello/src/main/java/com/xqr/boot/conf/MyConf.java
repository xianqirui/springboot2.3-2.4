package com.xqr.boot.conf;

import com.xqr.boot.bean.Card;
import com.xqr.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//proxyBeanMethods = true：是不是代理
/**
 * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
 * @return
 */
@EnableConfigurationProperties(Card.class)
//1.开启card属性配置功能（绑定功能）
//2.把card组件自动注册容器总
@Configuration(proxyBeanMethods = true) //配置类
public class MyConf {
    //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
    //保持组件单实例

    @Bean//给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        return new User("张三",15);
    }
}
