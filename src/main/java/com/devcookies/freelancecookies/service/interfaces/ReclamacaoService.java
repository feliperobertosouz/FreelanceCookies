package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Reclamacao;

import java.util.List;

public interface ReclamacaoService {


    public List<Reclamacao> getAllReclamacoes();

    public Reclamacao getReclamacaoById(int id);

    public Reclamacao createReclamacao(Reclamacao oferta);

    public void deleteReclamacao(int id);

    public List<Reclamacao> findAllReclamacoes();
}
