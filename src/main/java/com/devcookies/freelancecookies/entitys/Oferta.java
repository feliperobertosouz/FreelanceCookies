package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario Usuario;

    @Column(nullable = false)
    private String Titulo;

    @Column(nullable = false)
    private String Texto;

    private String Imagem;

    @Column(nullable = false)
    private int Prazo;

    @Column(nullable = false)
    private double Preco;

    @Column(nullable = false)
    private boolean Status;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date TempoAtual;


    public Oferta(int id, Usuario usuario_Id, String titulo, String texto, String imagem, int prazo, double preco, boolean status, Date tempoAtual) {
        Id = id;
        Usuario = usuario_Id;
        Titulo = titulo;
        Texto = texto;
        Imagem = imagem;
        Prazo = prazo;
        Preco = preco;
        Status = status;
        TempoAtual = tempoAtual;
    }

    public Oferta(Usuario usuario_Id, String titulo, String texto, String imagem, int prazo, double preco, boolean status, Date tempoAtual) {
        Usuario = usuario_Id;
        Titulo = titulo;
        Texto = texto;
        Imagem = imagem;
        Prazo = prazo;
        Preco = preco;
        Status = status;
        TempoAtual = tempoAtual;
    }

    public Oferta(Usuario usuario_Id, String titulo, String texto, int prazo, double preco, boolean status, Date tempoAtual) {
        Usuario = usuario_Id;
        Titulo = titulo;
        Texto = texto;
        Prazo = prazo;
        Preco = preco;
        Status = status;
        TempoAtual = tempoAtual;
    }

    public Oferta(){

    }

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
        this.Usuario = usuario_Id;
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

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String imagem) {
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

    public Date getTempoAtual() {
        return TempoAtual;
    }

    public void setTempoAtual(Date tempoAtual) {
        TempoAtual = tempoAtual;
    }
}
