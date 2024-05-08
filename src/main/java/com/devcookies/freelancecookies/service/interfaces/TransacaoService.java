package com.devcookies.freelancecookies.service.interfaces;
import com.devcookies.freelancecookies.dto.TransacaoDTO;
import com.devcookies.freelancecookies.entitys.Transacao;

import java.util.List;

public interface TransacaoService {


    public List<Transacao> getAllTransacoes();

    public Transacao getTransacaoById(int id);

    public TransacaoDTO createTransacao(TransacaoDTO transacao);

    public void deleteTransacao(int id);

    public List<Transacao> getAllTransacoesOfUsuario(int id);
}