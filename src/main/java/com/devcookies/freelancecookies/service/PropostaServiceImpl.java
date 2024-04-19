package com.devcookies.freelancecookies.service;


import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.repository.PropostaRepository;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropostaServiceImpl implements PropostaService {
    @Autowired
    private PropostaRepository propostaRepository;

    @Override
    public List<Proposta> getAllPropostas() {
        return propostaRepository.findAll();
    }

    @Override
    public Proposta getPropostaById(int id) {
        Optional<Proposta> optionalProposta = propostaRepository.findById(id);
        return optionalProposta.orElse(null);
    }

    @Override
    public Proposta saveProposta(Proposta proposta) {
        return propostaRepository.save(proposta);
    }

    @Override
    public void deleteProposta(int id) {
        propostaRepository.deleteById(id);
    }
}

