package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;

public class Reclamacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    @Column(nullable = false)
    private Usuario Usuario_Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private Transacao Transacao_Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    private DepositoSaque DepositoSaque_Id;

    @Column(nullable = false)
    private String Texto;

    private String TempoAtual;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(Usuario usuario_Id) {
        Usuario_Id = usuario_Id;
    }

    public Transacao getTransacao_Id() {
        return Transacao_Id;
    }

    public void setTransacao_Id(Transacao transacao_Id) {
        Transacao_Id = transacao_Id;
    }

    public DepositoSaque getDepositoSaque_Id() {
        return DepositoSaque_Id;
    }

    public void setDepositoSaque_Id(DepositoSaque depositoSaque_Id) {
        DepositoSaque_Id = depositoSaque_Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public String getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(String tempoAtual) {
        TempoAtual = tempoAtual;
    }
}
