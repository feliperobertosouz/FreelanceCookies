package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Nome;

    private String Email;

    private String Cpf;

    private String Telefone;

    private double Saldo;

    private double Nota;

    private double Avaliacoes;

    public Usuario(int id, String nome, String email, String cpf, String telefone, double saldo, double nota, double avaliacoes) {
        Id = id;
        Nome = nome;
        Email = email;
        Cpf = cpf;
        Telefone = telefone;
        Saldo = saldo;
        Nota = nota;
        Avaliacoes = avaliacoes;
    }

    public Usuario() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double nota) {
        Nota = nota;
    }

    public double getAvaliacoes() {
        return Avaliacoes;
    }

    public void setAvaliacoes(double avaliacoes) {
        Avaliacoes = avaliacoes;
    }
}
