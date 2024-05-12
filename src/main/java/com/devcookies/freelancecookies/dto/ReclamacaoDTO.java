package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Reclamacao;

import java.time.LocalDateTime;
import java.util.Date;

public class ReclamacaoDTO {
    private int id;
    private int usuarioId;
    private int usuarioReclamadoId;
    private String texto;
    private LocalDateTime tempoAtual;

    public ReclamacaoDTO() {
    }

    public ReclamacaoDTO(int id, int usuarioId, int usuarioReclamadoId, String texto, LocalDateTime tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarioReclamadoId = usuarioReclamadoId;
        this.texto = texto;
        this.tempoAtual = tempoAtual;
    }

    public ReclamacaoDTO(Reclamacao reclamacao){
        this.id = reclamacao.getId();
        this.usuarioId = reclamacao.getUsuario().getId();
        this.usuarioReclamadoId = reclamacao.getUsuarioReclamado().getId();
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
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getUsuarioReclamadoId() {
        return usuarioReclamadoId;
    }

    public void setUsuarioReclamadoId(int usuarioReclamadoId) {
        this.usuarioReclamadoId = usuarioReclamadoId;
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
}
