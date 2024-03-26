package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;

import java.sql.Blob;

public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Id")
    @Column(nullable = false)
    private Usuario Usuario_Id;

    @Column(nullable = false)
    private String Titulo;

    @Column(nullable = false)
    private String Texto;

    private Blob Imagem;

    @Column(nullable = false)
    private int Prazo;

    @Column(nullable = false)
    private double Preco;

    @Column(nullable = false)
    private boolean Status;

    @Column(nullable = false)
    private double TempoAtual;

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
        this.Usuario_Id = usuario_Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public Blob getImagem() {
        return Imagem;
    }

    public void setImagem(Blob imagem) {
        Imagem = imagem;
    }

    public int getPrazo() {
        return Prazo;
    }

    public void setPrazo(int prazo) {
        Prazo = prazo;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public double getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(double tempoAtual) {
        TempoAtual = tempoAtual;
    }
}
