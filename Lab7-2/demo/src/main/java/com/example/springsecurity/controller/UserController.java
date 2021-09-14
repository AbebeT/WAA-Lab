package com.example.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String home(){
        return ("<h1>welcome</h1>");
    }
    @GetMapping("/user")
    public String getUser(){
        return ("<h1>welcome user</h1>");
    }
    @GetMapping("/admin")
    public String getAdmin(){
        return ("<h1>welcome admin</h1>");
    }
}
