package com.example.keyclock.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('admin_role')")
    @GetMapping("/admin")
    public String adminEndpoint(Authentication authentication) {
        return "Hello Admin " + authentication.getName();
    }

    @PreAuthorize("hasRole('user_role')")
    @GetMapping("/user")
    public String userEndpoint(Authentication authentication) {
        return "Hello User " + authentication.getName();
    }
}
