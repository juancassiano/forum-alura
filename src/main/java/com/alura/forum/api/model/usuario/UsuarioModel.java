package com.alura.forum.api.model.usuario;

import com.alura.forum.domain.modelo.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioModel {

    String codigo;
    String nome;
    String email;
}
