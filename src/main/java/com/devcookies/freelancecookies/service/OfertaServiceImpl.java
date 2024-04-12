package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.repository.OfertaRepository;
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
    public List<Oferta> encontrarPorTitulo(String titulo) {
        return ofertaRepository.findByTitulo(titulo);
    }
}

