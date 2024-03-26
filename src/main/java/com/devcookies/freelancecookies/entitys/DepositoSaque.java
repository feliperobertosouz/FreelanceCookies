package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;

public class DepositoSaque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    @Column(nullable = false)
    private Usuario Usuario_Id;

    @Column(nullable = false)
    private double alteracao;

    @Column(nullable = false)
    private int agencia;

    @Column(nullable = false)
    private int conta;

    @Column(nullable = false)
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

    public double getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(double alteracao) {
        this.alteracao = alteracao;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(String tempoAtual) {
        TempoAtual = tempoAtual;
    }
}
