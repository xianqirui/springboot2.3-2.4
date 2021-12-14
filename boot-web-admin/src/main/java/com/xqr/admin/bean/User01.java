package com.xqr.admin.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
public class User01 {
    private Integer uid;
    private String uname;
    private String upwd;
}
