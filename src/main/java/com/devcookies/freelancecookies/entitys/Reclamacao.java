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
    private Usuario Usuario;

    @ManyToOne
    @JoinColumn(name = "UsuarioReclamado_Id")
    private Usuario UsuarioReclamado;

    @Column(nullable = false)
    private String Texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date TempoAtual;

    public Reclamacao() {
    }

    public Reclamacao(Usuario usuario_Id, Transacao transacao_Id, DepositoSaque depositoSaque_Id, String texto, String tempoAtual) {
        Usuario = usuario_Id;
        Transacao = transacao_Id;
        DepositoSaque = depositoSaque_Id;
        Texto = texto;
        TempoAtual = tempoAtual;
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
        Usuario = usuario_Id;
    }

    public Usuario getUsuarioReclamado() {
        return UsuarioReclamado;
    }

    public void setUsuarioReclamado(Usuario usuarioReclamado_Id) {
        UsuarioReclamado = usuarioReclamado_Id;
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
