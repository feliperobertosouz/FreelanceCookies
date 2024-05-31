package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Este é um exemplo simples. Você deve verificar as credenciais contra um banco de dados.
    public boolean authenticate(LoginDTO loginDTO) {
        // Exemplo de validação fictícia
        String dummyEmail = "user@example.com";
        String dummySenha = "password";

        return dummyEmail.equals(loginDTO.getEmail()) && dummySenha.equals(loginDTO.getSenha());
    }
}
