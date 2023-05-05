package com.alura.forum.api.model.resposta;

import com.alura.forum.api.model.usuario.UsuarioModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaModel {
    private String mensagem;
    private UsuarioModel autor;
    private boolean solucao;
}
