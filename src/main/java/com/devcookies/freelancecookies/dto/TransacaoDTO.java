package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Transacao;

import java.time.LocalDateTime;

public class TransacaoDTO {
    private int id;
    private UsuarioDTO pagadorId;
    private UsuarioDTO recebedorId;
    private OfertaDTO ofertaId;
    private LocalDateTime tempoAtual;
    private double transacao;

    public TransacaoDTO(int id, UsuarioDTO pagadorId, UsuarioDTO recebedorId, OfertaDTO ofertaId, LocalDateTime tempoAtual, double transacao) {
        this.id = id;
        this.pagadorId = pagadorId;
        this.recebedorId = recebedorId;
        this.ofertaId = ofertaId;
        this.tempoAtual = tempoAtual;
        this.transacao = transacao;
    }

    public TransacaoDTO(Transacao transacao){
        this.id = transacao.getId();
        this.pagadorId = new UsuarioDTO(transacao.getPagador().getId(), transacao.getPagador().getNome());
        this.recebedorId = new UsuarioDTO(transacao.getRecebedor().getId(), transacao.getRecebedor().getNome());
        this.ofertaId = new OfertaDTO(transacao.getOferta().getId(), transacao.getOferta().getTitulo());
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
        return UsuarioDTO.getId();
    }

    public void setPagadorId(int pagadorId) {this.pagadorId.setId(pagadorId);}

    public int getRecebedorId() {
        return UsuarioDTO.getId();
    }

    public void setRecebedorId(int recebedorId) {this.recebedorId.setId(recebedorId);
    }

    public int getOfertaId() {
        return OfertaDTO.getId();
    }

    public void setOfertaId(int ofertaId) {
        this.ofertaId.setId(ofertaId);
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

