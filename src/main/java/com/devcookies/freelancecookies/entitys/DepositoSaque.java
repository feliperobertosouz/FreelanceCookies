package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DepositoSaque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario Usuario;

    @Column(nullable = false)
    private double alteracao;

    @Column(nullable = false)
    private int agencia;

    @Column(nullable = false)
    private int conta;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date TempoAtual;


    public DepositoSaque(int id, Usuario usuario_Id, double alteracao, int agencia, int conta, Date tempoAtual) {
        Id = id;
        Usuario = usuario_Id;
        this.alteracao = alteracao;
        this.agencia = agencia;
        this.conta = conta;
        TempoAtual = tempoAtual;
    }

    public DepositoSaque(Usuario usuario_Id, double alteracao, int agencia, int conta, Date tempoAtual) {
        Usuario = usuario_Id;
        this.alteracao = alteracao;
        this.agencia = agencia;
        this.conta = conta;
        TempoAtual = tempoAtual;
    }

    public DepositoSaque(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario_Id) {
        Usuario = usuario_Id;
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

    public Date getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {TempoAtual = tempoAtual;}
}
