package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Oferta;

import java.util.List;

public interface OfertaService {
    List<Oferta> findAllOfertas();
    Oferta findOfertaById(Oferta oferta);
    Oferta saveOferta(Oferta oferta);
    void deleteOferta(Oferta oferta);
}
