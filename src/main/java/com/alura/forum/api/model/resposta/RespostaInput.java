package com.alura.forum.api.model.resposta;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespostaInput {

    @NotBlank(message = "Não pode ser nulo")
    private String mensagem;
    @NotBlank(message = "Não pode ser nulo")
    private String codigoAutor;
}
