package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario.getNome(), usuario.getEmail(), usuario.getCpf(), usuario.getTelefone(),
                usuario.getSaldo(), usuario.getNota(), usuario.getAvaliacoes());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable("id") int id, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findUsuarioById(id);
        if (existingUsuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.atualizarUsuario(id, usuario.getNome(), usuario.getEmail(), usuario.getCpf(), usuario.getTelefone(),
                usuario.getSaldo(), usuario.getNota(), usuario.getAvaliacoes());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioById(@PathVariable("id") int id) {
        Usuario usuario = usuarioService.findUsuarioById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuarioService.deletarUsuarioById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
