package com.devcookies.freelancecookies.dto;

import java.util.Date;

public class DepositoSaqueDTO {
    private int id;
    private int usuarioId;
    private double alteracao;
    private int agencia;
    private int conta;
    private Date tempoAtual;

    public DepositoSaqueDTO(int id, int usuarioId, double alteracao, int agencia, int conta, Date tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.alteracao = alteracao;
        this.agencia = agencia;
        this.conta = conta;
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
        return tempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

}
