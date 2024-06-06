package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Map<String, Boolean> loggedInUsers = new HashMap<>();

    public boolean authenticate(LoginDTO login) {
        Usuario user = usuarioRepository.findUsuarioByEmail(login.getEmail());
        if(user == null){
            return false;
        }
        String storedPassword = user.getSenha();
        if (storedPassword != null && storedPassword.equals(login.getSenha())) {
            loggedInUsers.put(login.getEmail(), true);
            return true;
        }
        return false;
    }

    public boolean logout(String email) {
        return loggedInUsers.remove(email) != null;
    }

    public boolean isAuthenticated(String email) {
        return loggedInUsers.getOrDefault(email, false);
    }
}