package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.dto.TransacaoDTO;
import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.service.interfaces.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoDTO>> findAllTransacoes(){
        List<TransacaoDTO> transacoes = transacaoService.getAllTransacoes();
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TransacaoDTO> createTransacao(@RequestBody TransacaoDTO transacao) {
        try{
            TransacaoDTO transacaoCreated = transacaoService.createTransacao(transacao);
            return new ResponseEntity<>(transacaoCreated, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDTO> getTransacao(@PathVariable("id") int id){
        try{
            TransacaoDTO transacaoSearched = transacaoService.getTransacaoById(id);
            if(transacaoSearched != null){
                return new ResponseEntity<>(transacaoSearched, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<TransacaoDTO> deleteTransacao(@PathVariable("id") int id){
        try{
            TransacaoDTO transacao = transacaoService.getTransacaoById(id);
            if(transacao != null){
                transacaoService.deleteTransacao(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

