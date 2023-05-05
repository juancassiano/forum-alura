package com.alura.forum.domain.modelo.exception;

public class RespostaNaoEncontradaException extends  EntidadeNaoEncontradoException{

    private static final long serialVersionUID = 1L;

    public RespostaNaoEncontradaException(Long respostaId){
        super(String.format("Não existe resposta com o id %d", respostaId));
    }
}
