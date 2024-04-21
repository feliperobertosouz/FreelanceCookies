package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.TransacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository TransacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Transacao createTransacao(Transacao transacao) {
        Usuario pagadorSearched = usuarioRepository.findUsuarioById(transacao.getPagador_Id().getId());
        Usuario recebedorSearched = usuarioRepository.findUsuarioById(transacao.getRecebedor_Id().getId());
        if(recebedorSearched == null || pagadorSearched == null)
            return null;
        transacao.setPagador_Id(pagadorSearched);
        transacao.setRecebedor_Id(recebedorSearched);
        try{
            Transacao transacaoCreated = TransacaoRepository.save(transacao);
            pagadorSearched.setSaldo(pagadorSearched.getSaldo() - transacao.getTransacao());
            usuarioRepository.save(pagadorSearched);
            recebedorSearched.setSaldo(recebedorSearched.getSaldo() + transacao.getTransacao());
            usuarioRepository.save(recebedorSearched);
            return transacaoCreated;
        }catch(Exception e){
            System.out.println("ERRO AO TENTAR CRIAR TRANSACAO");
            Transacao transacaoError = new Transacao();
            transacaoError.setTempoAtual("Problema ao criar usuario");
            return transacaoError;
        }
    }

    @Override
    public void deleteTransacao(int id) {

    }

    @Override
    public List<Transacao> getAllTransacoes() {
        return TransacaoRepository.findAll();
    }

    @Override
    public Transacao getTransacaoById(int id) {
        return TransacaoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Transacao> getAllTransacoesOfUsuario(int id) {
        return TransacaoRepository.findTransacoesByUsuario(id);
    }

}
