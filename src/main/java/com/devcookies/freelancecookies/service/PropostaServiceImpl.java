package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.PropostaDTO;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.repository.PropostaRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class PropostaServiceImpl implements PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private OfertaRepository ofertaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<PropostaDTO> getAllPropostas() {
        return findAllPropostas();
    }

    private List<PropostaDTO> findAllPropostas() {
        return propostaRepository.findAll().stream().map(PropostaDTO::new).collect(Collectors.toList());
    }

    @Override
    public Proposta getPropostaById(int id) {
        return null;
    }

    @Override
    public PropostaDTO createProposta(PropostaDTO proposta) {
        Usuario usuario = usuarioRepository.findUsuarioById(proposta.getUsuarioId());
        Oferta oferta = ofertaRepository.findOfertaById(proposta.getOfertaId());
        if(usuario == null || oferta == null)
            return null;
        Proposta createProposta = new Proposta(proposta, usuario, oferta);

        return new PropostaDTO(propostaRepository.save(createProposta));
    }

    @Override
    public void deleteProposta(int id) {
        Proposta propostaSearched = propostaRepository.findById(id).orElse(null);
        if(propostaSearched != null){
            propostaRepository.delete(propostaSearched);
        }
    }

    @Override
    public List<ReclamacaoDTO> findAllReclamacoes() {
        return null;
    }
}
