package com.alura.forum.api.assembler.usuarioAssemblers;

import com.alura.forum.api.model.input.UsuarioInput;
import com.alura.forum.domain.modelo.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Usuario toDomainObject(UsuarioInput usuarioInput){
        return modelMapper.map(usuarioInput, Usuario.class);
    }

    public void copyToDomainObject(UsuarioInput usuarioInput, Usuario usuario){
        modelMapper.map(usuarioInput, usuario);
    }
}
