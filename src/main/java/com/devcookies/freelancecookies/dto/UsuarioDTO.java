package com.devcookies.freelancecookies.dto;

import com.devcookies.freelancecookies.entitys.Usuario;

public class UsuarioDTO {

    private static int id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
    private double saldo;
    private double nota;
    private double avaliacoes;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.telefone = usuario.getTelefone();
        this.senha = usuario.getSenha();
        this.id = usuario.getId();
        this.saldo = usuario.getSaldo();
        this.avaliacoes = usuario.getAvaliacoes();
        this.nota = usuario.getNota();
    }

    public UsuarioDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UsuarioDTO(UsuarioDTO id, String nome) {

    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(double avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
