package com.devcookies.freelancecookies.dto;

import java.util.Date;

public class PropostaDTO {
    private int id;
    private int usuarioId;
    private int ofertaId;
    private String texto;
    private int prazo;
    private double preco;
    private Date tempoAtual;

    public PropostaDTO() {
    }

    public PropostaDTO(int id, int usuarioId, int ofertaId, String texto, int prazo, double preco, Date tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.ofertaId = ofertaId;
        this.texto = texto;
        this.prazo = prazo;
        this.preco = preco;
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

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        this.tempoAtual = tempoAtual;
    }
}

