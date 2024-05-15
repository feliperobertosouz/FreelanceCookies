package com.devcookies.freelancecookies.service.interfaces;
import com.devcookies.freelancecookies.dto.TransacaoDTO;
import com.devcookies.freelancecookies.entitys.Transacao;

import java.util.List;

public interface TransacaoService {


    List<TransacaoDTO> getAllTransacoes();

    TransacaoDTO getTransacaoById(int id);

    List<TransacaoDTO> findAllTransacoes();

    public TransacaoDTO createTransacao(TransacaoDTO transacao);

    public void deleteTransacao(int id);

    public List<Transacao> getAllTransacoesOfUsuario(int id);
}