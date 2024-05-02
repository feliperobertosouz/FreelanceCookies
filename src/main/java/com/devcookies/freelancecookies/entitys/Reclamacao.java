package com.devcookies.freelancecookies.entitys;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reclamacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "Usuario_Id")
    private Usuario Usuario_Id;

    @ManyToOne
    @JoinColumn(name = "UsuarioReclamado_Id")
    private Usuario UsuarioReclamado_Id;

    @Column(nullable = false)
    private String Texto;

    private Date TempoAtual;

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

    public Usuario getUsuarioReclamado_Id() {
        return UsuarioReclamado_Id;
    }

    public void setUsuarioReclamado_Id(Usuario usuarioReclamado_Id) {
        UsuarioReclamado_Id = usuarioReclamado_Id;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }

    public String getTempoAtual() {
        return TempoAtual.toString();
    }

    public void setTempoAtual(Date tempoAtual) {TempoAtual = tempoAtual;}
}
