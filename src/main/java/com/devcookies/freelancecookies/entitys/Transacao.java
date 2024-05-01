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
    private Usuario Pagador_Id;

    @ManyToOne
    @JoinColumn(name = "Recebedor_Id")
    private Usuario Recebedor_Id;

    @ManyToOne
    @JoinColumn(name = "Oferta_Id")
    private Oferta Oferta_Id;

    @Column(nullable = false)
    private Date TempoAtual;

    @Column(nullable = false)
    private double Transacao;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getPagador_Id() {
        return Pagador_Id;
    }

    public void setPagador_Id(Usuario pagador_Id) {
        Pagador_Id = pagador_Id;
    }

    public Usuario getRecebedor_Id() {
        return Recebedor_Id;
    }

    public void setRecebedor_Id(Usuario recebedor_Id) {
        Recebedor_Id = recebedor_Id;
    }

    public Oferta getOferta_Id() {
        return Oferta_Id;
    }

    public void setOferta_Id(Oferta oferta_Id) {
        Oferta_Id = oferta_Id;
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
