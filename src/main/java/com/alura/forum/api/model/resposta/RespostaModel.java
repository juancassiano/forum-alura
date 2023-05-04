package com.alura.forum.api.model.resposta;

import com.alura.forum.domain.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaModel {
    private String mensagem;
    private Usuario autor;
    private boolean solucao;
}
