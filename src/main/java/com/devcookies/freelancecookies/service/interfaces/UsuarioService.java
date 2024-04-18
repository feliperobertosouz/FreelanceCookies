package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();

    Usuario findUsuarioById(int id);
    Usuario cadastrarUsuario(Usuario usuario);

    Usuario atualizarUsuario(Usuario usuario);

    Usuario deletarUsuarioById(int id);
}
