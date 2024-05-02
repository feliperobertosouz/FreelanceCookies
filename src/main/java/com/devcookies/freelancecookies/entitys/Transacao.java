package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date TempoAtual;

    @Column(nullable = false)
    private double Transacao;

    public Transacao() {
    }

    public Transacao(Usuario pagador_Id, Usuario recebedor_Id, Oferta oferta_Id, String tempoAtual, double transacao) {
        Pagador_Id = pagador_Id;
        Recebedor_Id = recebedor_Id;
        Oferta_Id = oferta_Id;
        TempoAtual = tempoAtual;
        Transacao = transacao;
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

    public Date getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        TempoAtual = tempoAtual;
    }

    public double getTransacao() {
        return Transacao;
    }

    public void setTransacao(double transacao) {
        Transacao = transacao;
    }
}
