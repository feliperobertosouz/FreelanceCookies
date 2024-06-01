package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean authenticate(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());
        if (usuario != null) {
            return loginDTO.getSenha().equals(usuario.getSenha());
        }
        return false;
    }
}