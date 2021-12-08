package com.xqr.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/*
* 只有容器中的组件才有springboot的功能
* */
//@Component
@ConfigurationProperties(prefix = "mycard")
public class Card {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
