package com.alura.forum.domain.modelo.exception;


public class UsuarioEmUsoException extends EntidadeNaoEncontradoException {
    private static final long serialVersionUID = 1L;

    public UsuarioEmUsoException(String emailUsuario){
        super(String.format("Usuário com o email %s em uso.", emailUsuario));
    }
}
