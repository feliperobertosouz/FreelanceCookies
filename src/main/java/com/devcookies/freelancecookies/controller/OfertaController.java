package com.devcookies.freelancecookies.controller;


import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.service.interfaces.OfertaService;
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

    @GetMapping("/")
    public List<Oferta> getAllOfertas() {
        return ofertaService.findAllOfertas();
    }

    @GetMapping("/{id}")
    public Oferta getOfertaById(@PathVariable Oferta oferta) {
        return ofertaService.findOfertaById(oferta);
    }

    @PostMapping("/")
    public Oferta createOferta(@RequestBody Oferta oferta) {
        return ofertaService.saveOferta(oferta);
    }

    @PutMapping("/{id}")
    public Oferta updateOferta(@PathVariable Oferta oferta, @RequestBody Oferta ofertaAtualizada) {
        Oferta existingOferta = ofertaService.findOfertaById(oferta);
        if (existingOferta != null) {
            ofertaAtualizada.setId(oferta.getId());
            return ofertaService.saveOferta(ofertaAtualizada);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteOferta(@PathVariable Oferta oferta) {
        ofertaService.deleteOferta(oferta);
    }
}

