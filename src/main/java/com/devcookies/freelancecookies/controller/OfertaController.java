package com.devcookies.freelancecookies.controller;

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
    public ResponseEntity<List<Oferta>> findAllOfertas(){
        List<Oferta> ofertas = ofertaService.getAllOfertas();
        return new ResponseEntity<>(ofertas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Oferta> createOferta(@RequestBody Oferta oferta){
        try{
            Oferta ofertaCreated = ofertaService.createOferta(oferta);
            return new ResponseEntity<>(ofertaCreated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oferta> getOferta(@PathVariable("id") int id){
        try{
            Oferta ofertaSearched = ofertaService.getOfertaById(id);
            if(ofertaSearched != null){
                return new ResponseEntity<>(ofertaSearched, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Oferta> deleteOferta(@PathVariable("id") int id){
        try{
            Oferta oferta = ofertaService.getOfertaById(id);
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
