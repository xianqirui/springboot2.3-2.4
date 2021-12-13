package com.xqr.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.xqr")
public class BootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }

}
