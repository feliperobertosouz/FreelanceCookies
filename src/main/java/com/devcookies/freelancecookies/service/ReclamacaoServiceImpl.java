package com.devcookies.freelancecookies.service;

import com.devcookies.freelancecookies.dto.ReclamacaoDTO;
import com.devcookies.freelancecookies.entitys.Reclamacao;
import com.devcookies.freelancecookies.entitys.Usuario;
import com.devcookies.freelancecookies.repository.ReclamacaoRepository;
import com.devcookies.freelancecookies.repository.UsuarioRepository;
import com.devcookies.freelancecookies.service.interfaces.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamacaoServiceImpl implements ReclamacaoService {

    private final ReclamacaoRepository reclamacaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ReclamacaoServiceImpl(ReclamacaoRepository reclamacaoRepository, UsuarioRepository usuarioRepository) {
        this.reclamacaoRepository = reclamacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<ReclamacaoDTO> findAllReclamacoes() {
        return reclamacaoRepository.findAll().stream().map(ReclamacaoDTO::new).collect(Collectors.toList());
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
    public void deleteReclamacao(int id) {

    }
}