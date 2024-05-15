package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.dto.PropostaDTO;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Proposta;

import java.util.List;

public interface PropostaService {


    public List<PropostaDTO> getAllPropostas();

    public Proposta getPropostaById(int id);

    public PropostaDTO createProposta(PropostaDTO proposta);

    public void deleteProposta(int id);

    public List<ReclamacaoDTO> findAllReclamacoes();

}
