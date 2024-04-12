package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAllUsuarios();

    Usuario findUsuarioById(int id);

    void cadastrarUsuario(String nome, String email, String cpf, String telefone, double saldo, double nota, double avaliacoes);

    void atualizarUsuario(int id, String nome, String email, String cpf, String telefone, double saldo, double nota, double avaliacoes);

    void deletarUsuarioById(int id);
}
