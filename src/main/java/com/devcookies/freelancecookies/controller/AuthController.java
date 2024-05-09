package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.dto.UsuarioDTO;
import com.devcookies.freelancecookies.service.interfaces.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> realizarLogin(@RequestBody LoginDTO login) {
        UsuarioDTO usuarioDTO = authService.realizarLogin(login);

        if (usuarioDTO != null) {
            return ResponseEntity.ok(login);
        } else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}

