package com.alura.forum.api.model.topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoInput {

    @NotBlank(message = "{titulo.obrigadorio}")
    private String titulo;
    @NotBlank(message = "{mensagem.obrigatorio}")
    private String mensagem;
    @NotBlank(message = "{codigoAutor.obrigatorio}")
    private String codigoAutor;
    @NotBlank(message = "{nomeCurso.obrigatorio}")
    private String nomeCurso;
}
