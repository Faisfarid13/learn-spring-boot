package com.example.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
    @GetMapping("/")
    public String sayHello(){
        return "hello world";
    }

    @GetMapping("/home")
    public String homepage(){
        return "Ini homepage";
    }

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private String userAge;

    @GetMapping("/userinfo")
    public String userInfo(){
        return "User Name : "+userName+", User Age : "+userAge;
    }
}
