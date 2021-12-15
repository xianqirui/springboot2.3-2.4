package com.example.bootwebadminservice;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class BootWebAdminserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminserviceApplication.class, args);
    }

}
