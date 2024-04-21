package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.entitys.Oferta;

import java.util.List;

public interface OfertaService {

    public List<Oferta> getAllOfertas();
    public Oferta getOfertaById(int id);

    public Oferta createOferta(Oferta oferta);

    public void deleteOferta(int id);

}
