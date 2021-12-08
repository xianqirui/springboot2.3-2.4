package com.xqr.boot;

import com.xqr.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        //返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(Start.class, args);
        //查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //获取组件
        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        System.out.println("组件:"+(user01==user02));
        //
        boolean user011 = run.containsBean("user01");
        System.out.println("user组件:"+user011);

    }
}
