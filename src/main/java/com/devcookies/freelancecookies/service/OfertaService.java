package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Oferta;

import java.util.List;

public interface OfertaService {
    List<Oferta> encontrarPorTitulo(String titulo);
}

