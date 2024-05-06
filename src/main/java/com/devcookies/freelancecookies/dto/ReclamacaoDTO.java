package com.devcookies.freelancecookies.dto;

import java.util.Date;

public class ReclamacaoDTO {
    private int id;
    private int usuarioId;
    private int usuarioReclamadoId;
    private String texto;
    private Date tempoAtual;

    public ReclamacaoDTO() {
    }

    public ReclamacaoDTO(int id, int usuarioId, int usuarioReclamadoId, String texto, Date tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.usuarioReclamadoId = usuarioReclamadoId;
        this.texto = texto;
        this.tempoAtual = tempoAtual;
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

    public Date getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        this.tempoAtual = tempoAtual;
    }
}
