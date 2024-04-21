package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Proposta;

import java.util.List;

public interface PropostaService {


    public List<Proposta> getAllPropostas();

    public Proposta getPropostaById(int id);

    public Proposta createProposta(Proposta oferta);

    public void deleteProposta(int id);

}
