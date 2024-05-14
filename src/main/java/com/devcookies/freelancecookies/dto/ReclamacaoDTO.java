package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Reclamacao;

import java.time.LocalDateTime;

public class ReclamacaoDTO {
    private int id;
    private UsuarioDTO usuario;
    private UsuarioDTO usuarioReclamado;
    private String texto;
    private LocalDateTime tempoAtual;

    public ReclamacaoDTO() {
    }

    public ReclamacaoDTO(int id, UsuarioDTO usuario, UsuarioDTO usuarioReclamado, String texto, LocalDateTime tempoAtual) {
        this.id = id;
        this.usuario = usuario;
        this.usuarioReclamado = usuarioReclamado;
        this.texto = texto;
        this.tempoAtual = tempoAtual;
    }

    public ReclamacaoDTO(Reclamacao reclamacao){
        this.id = reclamacao.getId();
        this.usuario = new UsuarioDTO(reclamacao.getUsuario().getId(), reclamacao.getUsuario().getNome());
        this.usuarioReclamado = new UsuarioDTO(reclamacao.getUsuarioReclamado().getId(), reclamacao.getUsuarioReclamado().getNome());
        this.texto = reclamacao.getTexto();
        this.tempoAtual = reclamacao.getTempoAtual();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return UsuarioDTO.getId();
    }

    public void setUsuarioId(int usuarioId) {this.usuario.setId(usuarioId);}

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuarioReclamado() {
        return usuarioReclamado;
    }

    public void setUsuarioReclamado(UsuarioDTO usuarioReclamado) {
        this.usuarioReclamado = usuarioReclamado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

    public int getUsuarioReclamadoId() {
        if (usuarioReclamado != null) {
            return usuarioReclamado.getId();
        } else {
            return 0;
        }
    }

    public void setUsuarioReclamadoId(int usuarioId) {
        this.usuario.setId(usuarioId);
    }
}
