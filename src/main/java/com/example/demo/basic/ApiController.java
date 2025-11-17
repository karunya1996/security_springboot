package com.example.demo.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/user/data")
    public String userData() {
        return "This is USER data";
    }

    @GetMapping("/admin/data")
    public String adminData() {
        return "This is ADMIN data";
    }
}

