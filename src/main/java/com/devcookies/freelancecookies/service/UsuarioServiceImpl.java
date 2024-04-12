package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void cadastrarUsuario(String nome, String email, String cpf, String telefone, double saldo, double nota, double avaliacoes) {
        usuarioRepository.cadastrarUsuario(nome, email, cpf, telefone, saldo, nota, avaliacoes);
    }

    @Override
    public void atualizarUsuario(int id, String nome, String email, String cpf, String telefone, double saldo, double nota, double avaliacoes) {
        usuarioRepository.atualizarUsuario(id, nome, email, cpf, telefone, saldo, nota, avaliacoes);
    }

    @Override
    public void deletarUsuarioById(int id) {
        usuarioRepository.deletarUsuarioById(id);
    }
}
