package com.cauaananias.gerenciadordetarefas.dto;

import com.cauaananias.gerenciadordetarefas.domain.entities.Usuario;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(String id,
                         @NotBlank
                         String nome,
                         @NotBlank
                         String email,
                         @NotBlank
                         String senha) {

    public UsuarioDTO(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
