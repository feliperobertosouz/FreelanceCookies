package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.DepositoSaqueDTO;
import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.DepositoSaqueRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<DepositoSaqueDTO> findAllDepositoSaque() {
        return depositoSaqueRepository.findAll().stream().map(DepositoSaqueDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<DepositoSaqueDTO> getAllDepositoSaque() {
        return findAllDepositoSaque();
    }

    @Override
    public DepositoSaqueDTO getDepositoSaqueById(int id) {
        return depositoSaqueRepository.findById(id).map(DepositoSaqueDTO::new).orElse(null);
    }

    @Override
    public List<DepositoSaqueDTO> getAllDepositsOfUsuario(int id) {
        return depositoSaqueRepository.findDepositosByUsuario(id).stream().map(DepositoSaqueDTO::new).collect(Collectors.toList());
    }

}
