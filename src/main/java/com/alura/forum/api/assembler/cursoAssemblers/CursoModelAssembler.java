package com.alura.forum.api.assembler.cursoAssemblers;

import com.alura.forum.api.model.curso.CursoModel;
import com.alura.forum.domain.modelo.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CursoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CursoModel toModel(Curso curso){
        return modelMapper.map(curso, CursoModel.class);
    }

    public List<CursoModel> toCollectionModel(Collection<Curso> cursos){
        return cursos.stream().map(curso -> toModel(curso))
                .collect(Collectors.toList());
    }

}
