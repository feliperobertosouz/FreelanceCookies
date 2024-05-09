package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.DepositoSaqueDTO;
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
    public DepositoSaqueDTO createDepositoSaque(DepositoSaqueDTO depositoSaque) {
        Usuario usuarioSearched = usuarioRepository.findUsuarioById(depositoSaque.getUsuarioId());
        if(usuarioSearched == null)
            return null;
        depositoSaque.setUsuarioId(usuarioSearched.getId());
        try{
            DepositoSaque createDepositoSaque = new DepositoSaque(depositoSaque, usuarioSearched);
            usuarioSearched.setSaldo(usuarioSearched.getSaldo() + depositoSaque.getAlteracao());
            usuarioRepository.save(usuarioSearched);
            return new DepositoSaqueDTO(createDepositoSaque);
        }catch(Exception e){
            System.out.println("ERRO AO TENTAR CRIAR DEPOSITO");
            DepositoSaque depositoError = new DepositoSaque();
            depositoError.setTempoAtual(null);
            return new DepositoSaqueDTO(depositoError);
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
