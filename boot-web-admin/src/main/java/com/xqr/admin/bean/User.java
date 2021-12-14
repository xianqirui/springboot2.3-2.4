package com.xqr.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")//指定表，默认为表名
public class User {
    /*
    * 所有属性都应该在数据库中有
    * */
    @TableField(exist = false)//在表里不存在
    private String userName;
    @TableField(exist = false)
    private String password;
    //以下为数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
