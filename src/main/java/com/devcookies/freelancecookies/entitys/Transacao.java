package com.devcookies.freelancecookies.entitys;

import com.devcookies.freelancecookies.dto.TransacaoDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Pagador_Id")
    private Usuario Pagador;

    @ManyToOne
    @JoinColumn(name = "Recebedor_Id")
    private Usuario Recebedor;

    @ManyToOne
    @JoinColumn(name = "Oferta_Id")
    private Oferta Oferta;

    @Column(nullable = false)
    private LocalDateTime TempoAtual;

    @Column(nullable = false)
    private double Transacao;

    public Transacao() {
    }

    public Transacao(Usuario pagador_Id, Usuario recebedor_Id, Oferta oferta_Id, LocalDateTime tempoAtual, double transacao) {
        Pagador = pagador_Id;
        Recebedor = recebedor_Id;
        Oferta = oferta_Id;
        TempoAtual = tempoAtual;
        Transacao = transacao;
    }

    public Transacao(TransacaoDTO transacaoDTO, Oferta oferta, Usuario recebedor, Usuario pagador){
        Id = transacaoDTO.getId();
        Oferta = oferta;
        Pagador = pagador;
        Recebedor = recebedor;
        TempoAtual = transacaoDTO.getTempoAtual();
        Transacao = transacaoDTO.getTransacao();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getPagador() {
        return Pagador;
    }

    public void setPagador(Usuario pagador_Id) {
        Pagador = pagador_Id;
    }

    public Usuario getRecebedor() {
        return Recebedor;
    }

    public void setRecebedor(Usuario recebedor_Id) {
        Recebedor = recebedor_Id;
    }

    public Oferta getOferta() {
        return Oferta;
    }

    public void setOferta(Oferta oferta_Id) {
        Oferta = oferta_Id;
    }

    public LocalDateTime getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        TempoAtual = tempoAtual;
    }

    public double getTransacao() {
        return Transacao;
    }

    public void setTransacao(double transacao) {
        Transacao = transacao;
    }
}
