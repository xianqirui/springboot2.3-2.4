package com.xqr.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/*
* 只有容器中的组件才有springboot的功能
* */
//@Component
@Data //Lombok
@ToString
@ConfigurationProperties(prefix = "mycard")
public class Card {

    private int id;
    private String name;
}
