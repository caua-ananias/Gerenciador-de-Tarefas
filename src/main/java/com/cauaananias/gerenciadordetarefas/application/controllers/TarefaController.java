package com.cauaananias.gerenciadordetarefas.application.controllers;

import com.cauaananias.gerenciadordetarefas.application.services.TarefaService;
import com.cauaananias.gerenciadordetarefas.domain.entities.Tarefa;
import com.cauaananias.gerenciadordetarefas.dto.TarefaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> findAll() {
        List<Tarefa> tarefas = service.findAll();
        List<TarefaDTO> listDTO = tarefas.stream().map(TarefaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefa> findById(@Valid @PathVariable String id) {
        Tarefa tarefa = service.findById(id);
        return ResponseEntity.ok().body(tarefa);
    }

    @PostMapping
    public ResponseEntity<Tarefa> insert(@Valid @RequestBody TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa(null, tarefaDTO.titulo(), tarefaDTO.descricao(), null, null, false);
        tarefa.setDataCadastro((Date.from(Instant.now())));
        Tarefa tarefaInserida = service.insert(tarefa);
        return ResponseEntity.ok().body(tarefaInserida);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(Tarefa tarefa) {
        service.delete(tarefa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(@Valid @RequestBody TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa(tarefaDTO.id(), tarefaDTO.titulo(), tarefaDTO.descricao(), tarefaDTO.dataCadastro(), tarefaDTO.dataConclusao(), tarefaDTO.concluida());
        Tarefa tarefaAtualizada = service.update(tarefa);
        return ResponseEntity.ok().body(tarefaAtualizada);
    }

    @PutMapping(value = "/{id}/concluir")
    public ResponseEntity<Tarefa> concluir(@Valid @PathVariable String id) {
        Tarefa tarefa = service.findById(id);
        tarefa.setConcluida(true);
        tarefa.setDataConclusao(Date.from(Instant.now()));
        Tarefa tarefaConcluida = service.update(tarefa);
        return ResponseEntity.ok().body(tarefaConcluida);
    }
}