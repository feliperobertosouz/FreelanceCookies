package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
      Usuario repo = usuarioRepository.save(usuario);
      try{
          return usuarioRepository.save(repo);
      } catch (Exception e){
          return null;
      }
    }

    @Override
    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario repor = usuarioRepository.findById(usuario.getId()).orElse(null);
        if(repor != null){
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }

    }

    @Override
    public Usuario deletarUsuarioById(int id) {
        Usuario dele = usuarioRepository.findById(id).orElse(null);
        usuarioRepository.delete(dele);
        return dele;
    }


}
