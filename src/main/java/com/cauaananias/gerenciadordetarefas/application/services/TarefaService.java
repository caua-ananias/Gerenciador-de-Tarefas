package com.cauaananias.gerenciadordetarefas.application.services;

import com.cauaananias.gerenciadordetarefas.domain.entities.Tarefa;
import com.cauaananias.gerenciadordetarefas.domain.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Tarefa findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa insert(Tarefa tarefa) {
        return repository.insert(tarefa);
    }

    public void delete(Tarefa tarefa) {
        repository.delete(tarefa);
    }

    public Tarefa update(Tarefa tarefa) {
        Tarefa tarefaAtualizada = findById(tarefa.getId());
        updateData(tarefaAtualizada, tarefa);
        return repository.save(tarefaAtualizada);
    }

    private void updateData(Tarefa novaTarefa, Tarefa tarefa) {
        novaTarefa.setTitulo(tarefa.getTitulo());
        novaTarefa.setDescricao(tarefa.getDescricao());
        novaTarefa.setConcluida(tarefa.isConcluida());
        if (tarefa.isConcluida()) {
            novaTarefa.setDataConclusao(new Date());
        } else {
            novaTarefa.setDataConclusao(null);
        }
    }

    public Tarefa fromDTO(Tarefa tarefa) {
        return new Tarefa(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataCadastro(), tarefa.getDataConclusao(), tarefa.isConcluida());
    }

}