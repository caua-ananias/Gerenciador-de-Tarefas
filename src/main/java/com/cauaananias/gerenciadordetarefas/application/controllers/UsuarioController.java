package com.cauaananias.gerenciadordetarefas.application.controllers;

import com.cauaananias.gerenciadordetarefas.application.services.UsuarioService;
import com.cauaananias.gerenciadordetarefas.domain.entities.Usuario;
import com.cauaananias.gerenciadordetarefas.dto.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarios = service.findAll();
        List<UsuarioDTO> listDTO = usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@Valid @PathVariable String id) {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/{id}/tarefas")

    @PostMapping
    public ResponseEntity<Usuario> insert(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(null, usuarioDTO.nome(), usuarioDTO.email(), usuarioDTO.senha());
        Usuario usuarioInserido = service.insert(usuario);
        return ResponseEntity.ok().body(usuarioInserido);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Usuario id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
