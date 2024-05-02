package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaServiceImpl implements OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Oferta> getAllOfertas() {
        return ofertaRepository.findAll();
    }

    @Override
    public Oferta getOfertaById(int id) {
        return ofertaRepository.findById(id).orElse(null);
    }

    @Override
    public Oferta createOferta(Oferta oferta) {
        Usuario usuario = usuarioRepository.findUsuarioById(oferta.getUsuario().getId());
        if(usuario == null)
            return null;
        oferta.setUsuario(usuario);
        return ofertaRepository.save(oferta);
    }

    @Override
    public void deleteOferta(int id) {
        Oferta ofertaSearched = ofertaRepository.findById(id).orElse(null);
        if(ofertaSearched != null){
            ofertaRepository.delete(ofertaSearched);
        }
    }
}
