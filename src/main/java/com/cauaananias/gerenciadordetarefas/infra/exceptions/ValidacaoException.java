package com.cauaananias.gerenciadordetarefas.infra.exceptions;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String message) {
        super(message);
    }
}
