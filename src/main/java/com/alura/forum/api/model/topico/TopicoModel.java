package com.alura.forum.api.model.topico;

import com.alura.forum.api.model.curso.CursoModel;

import com.alura.forum.api.model.usuario.UsuarioModel;
import com.alura.forum.domain.modelo.StatusTopico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopicoModel {
    private String codigo;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private UsuarioModel autor;
    private CursoModel curso;
    private StatusTopico status;

//    private List<RespostaModel> resposta;
}
