package com.alura.forum.api.model.resposta;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaInput {

    @NotBlank(message = "{mensagem.obrigatorio}")
    private String mensagem;
    @NotBlank(message = "{codigoAutor.obrigatorio}")
    private String codigoAutor;
}
