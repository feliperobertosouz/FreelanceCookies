package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Transacao;

import java.time.LocalDateTime;
import java.util.Date;

public class TransacaoDTO {
    private int id;
    private int pagadorId;
    private int recebedorId;
    private int ofertaId;
    private LocalDateTime tempoAtual;
    private double transacao;

    public TransacaoDTO(int id, int pagadorId, int recebedorId, int ofertaId, LocalDateTime tempoAtual, double transacao) {
        this.id = id;
        this.pagadorId = pagadorId;
        this.recebedorId = recebedorId;
        this.ofertaId = ofertaId;
        this.tempoAtual = tempoAtual;
        this.transacao = transacao;
    }

    public TransacaoDTO(Transacao transacao){
        this.id = transacao.getId();
        this.pagadorId = transacao.getPagador().getId();
        this.recebedorId = transacao.getRecebedor().getId();
        this.ofertaId = transacao.getOferta().getId();
        this.tempoAtual = transacao.getTempoAtual();
        this.transacao = transacao.getTransacao();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPagadorId() {
        return pagadorId;
    }

    public void setPagadorId(int pagadorId) {
        this.pagadorId = pagadorId;
    }

    public int getRecebedorId() {
        return recebedorId;
    }

    public void setRecebedorId(int recebedorId) {
        this.recebedorId = recebedorId;
    }

    public int getOfertaId() {
        return ofertaId;
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId = ofertaId;
    }

    public LocalDateTime getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

    public double getTransacao() {
        return transacao;
    }

    public void setTransacao(double transacao) {
        this.transacao = transacao;
    }
}

