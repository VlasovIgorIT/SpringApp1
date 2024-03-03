package com.example.springapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@EnableFeignClients
@SpringBootApplication
public class SpringApp1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringApp1Application.class, args);
    }


}
