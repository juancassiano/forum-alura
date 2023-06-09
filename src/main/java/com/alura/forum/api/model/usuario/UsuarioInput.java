package com.alura.forum.api.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput{

        @NotBlank(message ="{nome.obrigatorio}")
        private String nome;
        @NotBlank(message ="{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        private String email;

        @NotBlank(message = "{senha.obrigatorio}")
        private String senha;
}
