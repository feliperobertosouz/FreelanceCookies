package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.dto.LoginResponseDTO;
import com.devcookies.freelancecookies.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO login) {
        try {
            boolean isAuthenticated = authService.authenticate(login);
            if (isAuthenticated) {
                return ResponseEntity.ok(new LoginResponseDTO("Logado"));
            } else {
                return ResponseEntity.status(401).body(new LoginResponseDTO("Alguma coisa deu errado"));
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