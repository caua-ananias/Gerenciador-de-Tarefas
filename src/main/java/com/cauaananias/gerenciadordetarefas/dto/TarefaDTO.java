package com.cauaananias.gerenciadordetarefas.dto;

import com.cauaananias.gerenciadordetarefas.domain.entities.Tarefa;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record TarefaDTO(
        String id,
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        Date dataCadastro,
        Date dataConclusao,
        boolean concluida
) {
    public TarefaDTO(Tarefa tarefa) {
        this(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getDataCadastro(),
                tarefa.getDataConclusao(),
                tarefa.isConcluida()
        );
    }
}