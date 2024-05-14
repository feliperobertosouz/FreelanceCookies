package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.OfertaDTO;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.service.interfaces.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ofertas")
public class OfertaController {

    @Autowired
    private OfertaService ofertaService;

    @GetMapping
    public ResponseEntity<List<OfertaDTO>> findAllOfertas() {
        List<OfertaDTO> ofertas = ofertaService.findAllOfertas();
        return new ResponseEntity<>(ofertas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OfertaDTO> createOferta(@RequestBody OfertaDTO oferta){
        try{
            OfertaDTO ofertaCreated = ofertaService.createOferta(oferta);
            return new ResponseEntity<>(ofertaCreated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaDTO> getOfertabyId(@PathVariable("id") int id) {
        OfertaDTO ofertaDTO = ofertaService.getOfertaById(id);
        if (ofertaDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ofertaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Oferta> deleteOferta(@PathVariable("id") int id){
        try{
            OfertaDTO oferta = ofertaService.getOfertaById(id);
            if(oferta != null){
                ofertaService.deleteOferta(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
