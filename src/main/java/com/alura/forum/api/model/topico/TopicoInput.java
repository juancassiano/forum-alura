package com.alura.forum.api.model.topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoInput {

    @NotBlank(message = "Não pode ser nulo")
    private String titulo;
    @NotBlank(message = "Não pode ser nulo")
    private String mensagem;
    @NotBlank(message = "Não pode ser nulo")
    private String codigoAutor;
    @NotBlank(message = "Não pode ser nulo")
    private String nomeCurso;
}
