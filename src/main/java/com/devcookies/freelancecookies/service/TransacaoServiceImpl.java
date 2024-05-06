package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.TransacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devcookies.freelancecookies.dto.TransacaoDTO;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Transacao createTransacao(Transacao transacao) {
        Usuario pagadorSearched = usuarioRepository.findUsuarioById(transacao.getPagador().getId());
        Usuario recebedorSearched = usuarioRepository.findUsuarioById(transacao.getRecebedor().getId());
        if(recebedorSearched == null || pagadorSearched == null)
            return null;
        transacao.setPagador(pagadorSearched);
        transacao.setRecebedor(recebedorSearched);
        try{
            Transacao transacaoCreated = transacaoRepository.save(transacao);
            pagadorSearched.setSaldo(pagadorSearched.getSaldo() - transacao.getTransacao());
            usuarioRepository.save(pagadorSearched);
            recebedorSearched.setSaldo(recebedorSearched.getSaldo() + transacao.getTransacao());
            usuarioRepository.save(recebedorSearched);
            return transacaoCreated;
        }catch(Exception e){
            System.out.println("ERRO AO TENTAR CRIAR TRANSACAO");
            Transacao transacaoError = new Transacao();
            return transacaoError;
        }
    }

    @Override
    public void deleteTransacao(int id) {

    }

    @Override
    public List<Transacao> getAllTransacoesOfUsuario(int id) {
        return transacaoRepository.findAll();
    }

    @Override
    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }

    @Override
    public Transacao getTransacaoById(int id) {
        return transacaoRepository.findById(id).orElse(null);
    }


}
