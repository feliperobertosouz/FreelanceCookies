package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ofertas")
public class OfertaController {

    private final OfertaService ofertaService;

    @Autowired
    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }

    @GetMapping("/por-titulo")
    public List<Oferta> encontrarOfertasPorTitulo(@RequestParam String titulo) {
        return ofertaService.encontrarPorTitulo(titulo);
    }
}

