package com.cauaananias.gerenciadordetarefas.dto;

import com.cauaananias.gerenciadordetarefas.domain.entities.Tarefa;

import java.util.Date;

public record TarefaDTO(
        String id,
        String titulo,
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