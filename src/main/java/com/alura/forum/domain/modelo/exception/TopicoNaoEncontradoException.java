package com.alura.forum.domain.modelo.exception;


public class TopicoNaoEncontradoException extends EntidadeNaoEncontradoException {
    private static final long serialVersionUID = 1L;

    public TopicoNaoEncontradoException(String codigoTopico){
        super(String.format("Não existe um tópico com o código %s.", codigoTopico));
    }
}
