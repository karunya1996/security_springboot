package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Security Demo!";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "Hello USER!";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Hello ADMIN!";
    }
/*
    @GetMapping("/login")
    public String loginPage() {
        return "Please login using the form!";
    }
    */
}
