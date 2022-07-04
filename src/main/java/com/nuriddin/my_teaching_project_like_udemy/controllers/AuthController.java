package com.nuriddin.my_teaching_project_like_udemy.controllers;


// t.me/superJavaDeveloper 08.05.2022;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

//    @GetMapping("/register")
//    public String getRegisterPage() {
//        return "register";
//    }
}
