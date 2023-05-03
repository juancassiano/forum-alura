package com.alura.forum.api.model.topico;

import com.alura.forum.api.model.usuario.UsuarioInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
