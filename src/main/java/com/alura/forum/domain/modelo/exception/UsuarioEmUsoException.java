package com.alura.forum.domain.modelo.exception;


public class UsuarioEmUsoException extends EntidadeNaoEncontradoException {
    private static final long serialVersionUID = 1L;

    public UsuarioEmUsoException(String codigoUsuario){
        super(String.format("Usuário com o código %s em uso.", codigoUsuario));
    }
}
