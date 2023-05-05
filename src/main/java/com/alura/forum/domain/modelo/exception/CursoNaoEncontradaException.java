package com.alura.forum.domain.modelo.exception;

public class CursoNaoEncontradaException extends  EntidadeNaoEncontradoException{

    private static final long serialVersionUID = 1L;

    public CursoNaoEncontradaException(String cursoNome){
        super(String.format("Não existe curso com o nome %s", cursoNome));
    }
}
