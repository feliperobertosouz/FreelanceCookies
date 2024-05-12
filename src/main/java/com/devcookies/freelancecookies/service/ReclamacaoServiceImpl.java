package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.DepositoSaque;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.entitys.Transacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.DepositoSaqueRepository;
import com.devcookies.freelancecookies.repository.ReclamacaoRepository;
import com.devcookies.freelancecookies.repository.TransacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamacaoServiceImpl implements ReclamacaoService {

    @Autowired
    private ReclamacaoRepository reclamacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DepositoSaqueRepository depositoSaqueRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public List<Reclamacao> findAllReclamacoes() {
        return reclamacaoRepository.findAll();
    }

    @Override
    public List<Reclamacao> getAllReclamacoes() {
        return null;
    }

    @Override
    public Reclamacao getReclamacaoById(int id) {
        return reclamacaoRepository.findById(id).orElse(null);
    }

    @Override
    public ReclamacaoDTO createReclamacao(ReclamacaoDTO reclamacao) {
        Usuario usuario = usuarioRepository.findUsuarioById(reclamacao.getUsuarioId());
        Usuario usuarioReclamado = usuarioRepository.findUsuarioById(reclamacao.getUsuarioReclamadoId());
        if(usuario == null || usuarioReclamado == null)
            return null;
        Reclamacao createReclamacao = new Reclamacao(reclamacao, usuario, usuarioReclamado);
        reclamacao.setUsuarioId(usuario.getId());
        reclamacao.setUsuarioReclamadoId(usuarioReclamado.getId());
        return new ReclamacaoDTO(reclamacaoRepository.save(createReclamacao));
    }

    @Override
    public void deleteReclamacao(int id) {

    }
}
