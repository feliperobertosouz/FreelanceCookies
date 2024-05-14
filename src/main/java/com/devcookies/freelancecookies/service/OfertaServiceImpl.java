package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.OfertaDTO;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<OfertaDTO> findAllOfertas() {
        return ofertaRepository.findAll().stream().map(OfertaDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<OfertaDTO> getAllOfertas() {
        return findAllOfertas();
    }

    @Override
    public OfertaDTO getOfertaById(int id) {
        return ofertaRepository.findById(id).map(OfertaDTO::new).orElse(null);
    }

    @Override
    public OfertaDTO createOferta(OfertaDTO ofertaDTO) {
        Usuario usuario = usuarioRepository.findUsuarioById(OfertaDTO.getUsuarioId());
        if (usuario == null)
            return null;
        Oferta oferta = new Oferta(ofertaDTO, usuario);
        Oferta savedOferta = ofertaRepository.save(oferta);
        return new OfertaDTO(savedOferta);
    }

    @Override
    public void deleteOferta(int id) {

    }
}
