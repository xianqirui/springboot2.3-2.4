package com.example.bootweb01.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Person {

    private String name;
    private Integer agr;
    private Date date;
}
