package com.xqr.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyexception extends RuntimeException{
    public UserTooManyexception(){

    }
    public UserTooManyexception(String message){
        super(message);
    }
}
