package com.devcookies.freelancecookies.service.interfaces;

import com.devcookies.freelancecookies.dto.OfertaDTO;

import java.util.List;

public interface OfertaService {

    List<OfertaDTO> findAllOfertas();

    public List<OfertaDTO> getAllOfertas();
    public OfertaDTO getOfertaById(int id);

    public OfertaDTO createOferta(OfertaDTO oferta);

    public void deleteOferta(int id);

}
