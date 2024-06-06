package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private Map<String, String> userDatabase = new HashMap<>();
    private Map<String, Boolean> loggedInUsers = new HashMap<>();

    public boolean authenticate(LoginDTO login) {
        String storedPassword = userDatabase.get(login.getEmail());
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