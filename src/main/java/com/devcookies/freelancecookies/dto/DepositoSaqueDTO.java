package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.DepositoSaque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DepositoSaqueDTO {
    private int id;
    private int usuarioId;
    private double alteracao;
    private int agencia;
    private int conta;
    private LocalDateTime tempoAtual;

    public DepositoSaqueDTO(int id, int usuarioId, double alteracao, int agencia, int conta, LocalDateTime tempoAtual) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.alteracao = alteracao;
        this.agencia = agencia;
        this.conta = conta;
        this.tempoAtual = tempoAtual;
    }

    public DepositoSaqueDTO(DepositoSaque depositoSaque){
        this.id = depositoSaque.getId();
        this.usuarioId = depositoSaque.getUsuario().getId();
        this.agencia = depositoSaque.getAgencia();
        this.conta = depositoSaque.getConta();
        this.tempoAtual = depositoSaque.getTempoAtual();
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

    public LocalDateTime getTempoAtual() {
        return tempoAtual;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

}
