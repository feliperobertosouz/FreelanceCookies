package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.PropostaDTO;
import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.repository.PropostaRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
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
    public List<Proposta> getAllPropostas() {
        return propostaRepository.findAll();
    }

    @Override
    public Proposta getPropostaById(int id) {
        return propostaRepository.findById(id).orElse(null);
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
}
