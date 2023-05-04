package com.alura.forum.api.model.resposta;

import com.alura.forum.api.model.usuario.UsuarioInput;
import com.alura.forum.domain.modelo.Usuario;
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
