package com.devcookies.freelancecookies.controller;


import com.devcookies.freelancecookies.entitys.Proposta;
import com.devcookies.freelancecookies.service.interfaces.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public List<Proposta> getAllPropostas() {
        return propostaService.getAllPropostas();
    }

    @GetMapping("/{id}")
    public Proposta getPropostaById(@PathVariable int id) {
        return propostaService.getPropostaById(id);
    }

    @PostMapping
    public Proposta saveProposta(@RequestBody Proposta proposta) {
        return propostaService.saveProposta(proposta);
    }

    @DeleteMapping("/{id}")
    public void deleteProposta(@PathVariable int id) {
        propostaService.deleteProposta(id);
    }
}
