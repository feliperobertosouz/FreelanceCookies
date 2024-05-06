package com.devcookies.freelancecookies.dto;

import java.util.Date;

public class OfertaDTO {
    private int id;
    private int usuarioId;
    private String titulo;
    private String texto;
    private String imagem;
    private int prazo;
    private double preco;
    private boolean status;
    private Date tempoAtual;


    public OfertaDTO() {}

    public OfertaDTO(int id, int usuarioId, String titulo, String texto, String imagem, int prazo, double preco, boolean status, Date tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.prazo = prazo;
        this.preco = preco;
        this.status = status;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        this.tempoAtual = tempoAtual;
    }
}

