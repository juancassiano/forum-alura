package com.alura.forum.api.model.curso;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoInput {

    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
    @NotBlank(message = "{categoria.obrigatorio}")
    private String categoria;
}
