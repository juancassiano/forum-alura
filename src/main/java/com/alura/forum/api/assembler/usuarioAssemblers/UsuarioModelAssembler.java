package com.alura.forum.api.assembler.usuarioAssemblers;

import com.alura.forum.api.model.usuario.UsuarioModel;
import com.alura.forum.domain.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioModel toModel(Usuario usuario){
        return modelMapper.map(usuario, UsuarioModel.class);
    }

    public List<UsuarioModel> toCollectionModel(Collection<Usuario> usuarios){
        return usuarios.stream().map(usuario -> toModel(usuario))
                .collect(Collectors.toList());
    }
}
