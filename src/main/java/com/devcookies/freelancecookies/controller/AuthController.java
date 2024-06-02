package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO login) {
        try {
            boolean isAuthenticated = authService.authenticate(login);
            if (isAuthenticated) {
                return ResponseEntity.ok(login);
            } else {
                return ResponseEntity.status(401).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LoginDTO login) {
        boolean isLoggedOut = authService.logout(login.getEmail());
        if (isLoggedOut) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(400).build();
        }
    }
}