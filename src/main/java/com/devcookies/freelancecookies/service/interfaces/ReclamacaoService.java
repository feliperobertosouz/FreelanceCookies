package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.dto.ReclamacaoDTO;

import java.util.List;

public interface ReclamacaoService {


    public List<ReclamacaoDTO> getAllReclamacoes();

    public ReclamacaoDTO getReclamacaoById(int id);

    public ReclamacaoDTO createReclamacao(ReclamacaoDTO oferta);

    public void deleteReclamacao(int id);

    public List<ReclamacaoDTO> findAllReclamacoes();
}
