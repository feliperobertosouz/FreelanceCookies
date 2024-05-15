package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.PropostaDTO;
import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public ResponseEntity<List<PropostaDTO>> findAllPropostas(){
        List<PropostaDTO> propostas = propostaService.getAllPropostas();
        return new ResponseEntity<>(propostas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PropostaDTO> createProposta(@RequestBody PropostaDTO proposta) {
        try{
            PropostaDTO propostaCreated = propostaService.createProposta(proposta);
            return new ResponseEntity<>(propostaCreated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proposta> getProposta(@PathVariable("id") int id){
        try{
            Proposta propostaSearched = propostaService.getPropostaById(id);
            if(propostaSearched != null){
                return new ResponseEntity<>(propostaSearched, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Proposta> deleteProposta(@PathVariable("id") int id){
        try{
            Proposta proposta = propostaService.getPropostaById(id);
            if(proposta != null){
                propostaService.deleteProposta(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

