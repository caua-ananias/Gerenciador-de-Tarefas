package com.cauaananias.gerenciadordetarefas.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private Date dataCadastro;
    private Date dataConclusao;
    private boolean concluida;

}