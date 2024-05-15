package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Proposta;

import java.time.LocalDateTime;
import java.util.Date;

public class PropostaDTO {
    private int id;
    private UsuarioDTO usuarioId;
    private OfertaDTO ofertaId;
    private String texto;
    private int prazo;
    private double preco;
    private LocalDateTime tempoAtual;

    public PropostaDTO() {
    }

    public PropostaDTO(int id, UsuarioDTO usuarioId, OfertaDTO ofertaId, String texto, int prazo, double preco, LocalDateTime tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.ofertaId = ofertaId;
        this.texto = texto;
        this.prazo = prazo;
        this.preco = preco;
        this.tempoAtual = tempoAtual;
    }

    public PropostaDTO(Proposta proposta){
        this.id = proposta.getId();
        this.usuarioId = new UsuarioDTO(proposta.getUsuario().getId(), proposta.getUsuario().getNome());
        this.ofertaId = new OfertaDTO(proposta.getOferta().getId(), proposta.getOferta().getTitulo());
        this.texto = proposta.getTexto();
        this.prazo = proposta.getPrazo();
        this.preco = proposta.getPreco();
        this.tempoAtual = proposta.getTempoAtual();
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

    public void setUsuarioId(int usuarioId) {this.usuarioId.setId(usuarioId);}

    public int getOfertaId() {
        return OfertaDTO.getId();
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId.setId(ofertaId);
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

    public LocalDateTime getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }
}

