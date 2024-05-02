package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.DepositoSaqueRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositoSaqueServiceImpl implements DepositoService {

    @Autowired
    private DepositoSaqueRepository depositoSaqueRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public DepositoSaque createDepositoSaque(DepositoSaque depositoSaque) {
        Usuario usuarioSearched = usuarioRepository.findUsuarioById(depositoSaque.getUsuario().getId());
        if(usuarioSearched == null)
            return null;
        depositoSaque.setUsuario(usuarioSearched);
        try{
            DepositoSaque depositoCreated = depositoSaqueRepository.save(depositoSaque);
            usuarioSearched.setSaldo(usuarioSearched.getSaldo() + depositoSaque.getAlteracao());
            usuarioRepository.save(usuarioSearched);
            return depositoCreated;
        }catch(Exception e){
            System.out.println("ERRO AO TENTAR CRIAR DEPOSITO");
            DepositoSaque depositoError = new DepositoSaque();
            depositoError.setTempoAtual(null);
            return depositoError;
        }
    }

    @Override
    public List<DepositoSaque> getAllDepositoSaque() {
        return depositoSaqueRepository.findAll();
    }

    @Override
    public DepositoSaque getDepositoSaqueById(int id) {
        return depositoSaqueRepository.findById(id).orElse(null);
    }

    @Override
    public List<DepositoSaque> getAllDepositsOfUsuario(int id) {
        return depositoSaqueRepository.findDepositosByUsuario(id);
    }

}
