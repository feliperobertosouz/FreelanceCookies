package com.devcookies.freelancecookies.controller;

import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.service.interfaces.DepositoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/deposito")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    @GetMapping
    public ResponseEntity<List<DepositoSaque>> getAllDepositos(){
        try{
            return new ResponseEntity<>(depositoService.getAllDepositoSaque(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepositoSaque> getDeposito(@PathVariable("id")int id){
        try{
            DepositoSaque deposito = depositoService.getDepositoSaqueById(id);
            return new ResponseEntity<>(deposito, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<DepositoSaque> createDepositoSaque(@RequestBody DepositoSaque depositoSaque){
        try{
            DepositoSaque depositoCreated = depositoService.createDepositoSaque(depositoSaque);
            return new ResponseEntity<>(depositoCreated, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/byUsuario/{usuarioId}")
    public ResponseEntity<List<DepositoSaque>> getDepositoByUsuarioId(@PathVariable("usuarioId") int usuarioId){
        try{
            return new ResponseEntity<>(depositoService.getAllDepositsOfUsuario(usuarioId), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
