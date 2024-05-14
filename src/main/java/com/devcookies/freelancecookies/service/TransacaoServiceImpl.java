package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Oferta;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.TransacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devcookies.freelancecookies.dto.TransacaoDTO;
import com.devcookies.freelancecookies.repository.OfertaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private OfertaRepository ofertaRepository;

    @Override
    public List<TransacaoDTO> findAllTransacoes() {
        return transacaoRepository.findAll().stream().map(TransacaoDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ReclamacaoDTO> getAllReclamacoes() {
        return findAllReclamacoes();
    }

    @Override
    public ReclamacaoDTO getReclamacaoById(int id) {
        return reclamacaoRepository.findById(id).map(ReclamacaoDTO::new).orElse(null);
    }

    @Override
    public ReclamacaoDTO createReclamacao(ReclamacaoDTO reclamacaoDTO) {
        Usuario usuario = usuarioRepository.findUsuarioById(reclamacaoDTO.getUsuarioId());
        Usuario usuarioReclamado = usuarioRepository.findUsuarioById(reclamacaoDTO.getUsuarioReclamadoId());
        if (usuario == null || usuarioReclamado == null)
            return null;
        Reclamacao reclamacao = new Reclamacao(reclamacaoDTO, usuario, usuarioReclamado);
        Reclamacao savedReclamacao = reclamacaoRepository.save(reclamacao);
        return new ReclamacaoDTO(savedReclamacao);
    }
    @Override
    public TransacaoDTO createTransacao(TransacaoDTO transacao) {
        Usuario pagadorSearched = usuarioRepository.findUsuarioById(transacao.getPagadorId());
        Usuario recebedorSearched = usuarioRepository.findUsuarioById(transacao.getRecebedorId());
        Oferta oferta = ofertaRepository.findOfertaById(transacao.getOfertaId());
        if(recebedorSearched == null || pagadorSearched == null)
            return null;
        transacao.setPagadorId(pagadorSearched.getId());
        transacao.setRecebedorId(recebedorSearched.getId());
        try{
            Transacao createTransacao = new Transacao(transacao, oferta, pagadorSearched, recebedorSearched);
            pagadorSearched.setSaldo(pagadorSearched.getSaldo() - transacao.getTransacao());
            usuarioRepository.save(pagadorSearched);
            recebedorSearched.setSaldo(recebedorSearched.getSaldo() + transacao.getTransacao());
            usuarioRepository.save(recebedorSearched);
            return new TransacaoDTO(createTransacao);
        }catch(Exception e){
            System.out.println("ERRO AO TENTAR CRIAR TRANSACAO");
            Transacao transacaoError = new Transacao();
            return new TransacaoDTO(transacaoError);
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
