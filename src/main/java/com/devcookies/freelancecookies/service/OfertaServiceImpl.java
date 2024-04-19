package com.devcookies.freelancecookies.service;


import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.repository.OfertaRepository;
import com.devcookies.freelancecookies.service.interfaces.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaServiceImpl implements OfertaService {

    private final OfertaRepository ofertaRepository;

    @Autowired
    public OfertaServiceImpl(OfertaRepository ofertaRepository) {
        this.ofertaRepository = ofertaRepository;
    }

    @Override
    public List<Oferta> findAllOfertas() {
        return ofertaRepository.findAll();
    }

    @Override
    public Oferta findOfertaById(Oferta oferta) {
        return ofertaRepository.findById(oferta.getId()).orElse(null);
    }

    @Override
    public Oferta saveOferta(Oferta oferta) {
        return ofertaRepository.save(oferta);
    }

    @Override
    public void deleteOferta(Oferta oferta) {
        ofertaRepository.delete(oferta);
    }
}

