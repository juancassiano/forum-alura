package com.alura.forum.domain.modelo.exception;

public class UsuarioNaoEncontradoException extends  EntidadeNaoEncontradoException{

    private static final long serialVersionUID = 1L;

    public UsuarioNaoEncontradoException(String usuarioCodigo){
        super(String.format("Não existe usuário com o código %d", usuarioCodigo));
    }
}
