package com.cauaananias.gerenciadordetarefas.domain.repositories;

import com.cauaananias.gerenciadordetarefas.domain.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
