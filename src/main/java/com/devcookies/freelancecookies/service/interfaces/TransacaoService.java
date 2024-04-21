package com.devcookies.freelancecookies.service.interfaces;
import com.devcookies.freelancecookies.entitys.Transacao;

import java.util.List;

public interface TransacaoService {


    public List<Transacao> getAllTransacoes();

    public Transacao getTransacaoById(int id);

    public Transacao createTransacao(Transacao transacao);

    public void deleteTransacao(int id);

    public List<Transacao> getAllTransacoesOfUsuario(int id);
}