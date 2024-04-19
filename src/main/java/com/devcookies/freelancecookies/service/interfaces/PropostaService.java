package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Proposta;
import java.util.List;

public interface PropostaService {
    List<Proposta> getAllPropostas();
    Proposta getPropostaById(int id);
    Proposta saveProposta(Proposta proposta);
    void deleteProposta(int id);
}
