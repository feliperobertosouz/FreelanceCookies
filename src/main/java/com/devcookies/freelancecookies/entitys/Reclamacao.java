package com.devcookies.freelancecookies.entitys;

import com.devcookies.freelancecookies.controller.UsuarioController;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Reclamacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "UsuarioReclamado_Id")
    private Usuario UsuarioReclamado;

    @Column(nullable = false)
    private String Texto;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime TempoAtual;

    public Reclamacao() {
    }

    public Reclamacao(Usuario usuario_Id, Transacao transacao_Id, DepositoSaque depositoSaque_Id, String texto, LocalDateTime tempoAtual, Usuario UsuarioReclamado_Id) {
        Usuario = usuario_Id;
        UsuarioReclamado =  UsuarioReclamado_Id;
        Texto = texto;
        TempoAtual = tempoAtual;
    }

    public Reclamacao(ReclamacaoDTO reclamacaoDTO, Usuario usuario, Usuario usuarioReclamado){
        Id = reclamacaoDTO.getId();
        UsuarioReclamado = usuarioReclamado;
        Usuario = usuario;
        Texto = reclamacaoDTO.getTexto();
        TempoAtual = reclamacaoDTO.getTempoAtual();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario_Id) {
        Usuario = usuario_Id;
    }

    public Usuario getUsuarioReclamado() {
        return UsuarioReclamado;
    }

    public void setUsuarioReclamado(Usuario usuarioReclamado_Id) {
        UsuarioReclamado = usuarioReclamado_Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public LocalDateTime getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {TempoAtual = tempoAtual;}
}
