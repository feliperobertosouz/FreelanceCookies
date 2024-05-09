package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.LoginDTO;
import com.devcookies.freelancecookies.dto.UsuarioDTO;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO realizarLogin(LoginDTO loginDTO) {

        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario != null && usuario.getSenha().equals(loginDTO.getSenha())) {
            return convertToDto(usuario);
        } else {
            return null;
        }
    }
    private UsuarioDTO convertToDto(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getSenha(),
                usuario.getSaldo(),
                usuario.getNota(),
                usuario.getAvaliacoes()
        );
    }
}