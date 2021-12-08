package com.xqr.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造
public class User {
    private String name;
    private int age;
}
