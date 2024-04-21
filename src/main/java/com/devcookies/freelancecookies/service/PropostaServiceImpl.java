package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.repository.PropostaRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Proposta createProposta(Proposta proposta) {
        Usuario usuario = usuarioRepository.findUsuarioById(proposta.getUsuario_Id().getId());
        Oferta oferta = ofertaRepository.findOfertaById(proposta.getOferta_Id().getId());
        if(usuario == null || oferta == null)
            return null;
        proposta.setUsuario_Id(usuario);
        return propostaRepository.save(proposta);
    }

    @Override
    public void deleteProposta(int id) {
        Proposta propostaSearched = propostaRepository.findById(id).orElse(null);
        if(propostaSearched != null){
            propostaRepository.delete(propostaSearched);
        }
    }
}
