package com.example.demo.Oauth;
import com.example.demo.jwt.SecurityConfig;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

    private final SecurityConfig securityConfig2;

    HomeController(SecurityConfig securityConfig) {
        this.securityConfig2 = securityConfig;
    }

    @GetMapping("/")
    public String home() {
        return "home"; // public page
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, OAuth2AuthenticationToken authentication) {
       model.securityConfig2("userName", authentication.getPrincipal().getAttribute("name"));
        return "dashboard"; // secured page
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // custom login page
    }
}
