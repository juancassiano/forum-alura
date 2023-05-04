package com.alura.forum.domain.modelo.exception;


public class TopicoEmUsoException extends EntidadeNaoEncontradoException {
    private static final long serialVersionUID = 1L;

    public TopicoEmUsoException(String codigoTopico){
        super(String.format("Tópico com o código %s em uso.", codigoTopico));
    }
}
