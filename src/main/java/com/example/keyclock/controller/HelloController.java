package com.example.keyclock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Anyone can see this";
    }

    @GetMapping("/private")
    public String privateEndpoint(Authentication authentication) {
        return "Hello " + authentication.getName();
    }
}
