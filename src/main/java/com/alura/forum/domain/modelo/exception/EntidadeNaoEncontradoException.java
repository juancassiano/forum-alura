package com.alura.forum.domain.modelo.exception;

import jakarta.persistence.EntityNotFoundException;

public class EntidadeNaoEncontradoException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
