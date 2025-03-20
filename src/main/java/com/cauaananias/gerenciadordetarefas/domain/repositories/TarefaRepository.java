package com.cauaananias.gerenciadordetarefas.domain.repositories;

import com.cauaananias.gerenciadordetarefas.domain.entities.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefaRepository extends MongoRepository<Tarefa, String> {
}
