package com.cauaananias.gerenciadordetarefas.application.services;

import com.cauaananias.gerenciadordetarefas.domain.entities.Usuario;
import com.cauaananias.gerenciadordetarefas.domain.repositories.UsuarioRepository;
import com.cauaananias.gerenciadordetarefas.infra.exceptions.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario insert(Usuario usuario) {
        return repository.insert(usuario);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Usuário não encontrado"));
    }

    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }

    public Usuario fromDTO(Usuario usuario) {
        return new Usuario(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }


}
