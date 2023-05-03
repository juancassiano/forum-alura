package com.alura.forum.api.assembler.cursoAssemblers;

import com.alura.forum.api.model.curso.CursoInput;
import com.alura.forum.api.model.curso.CursoModel;
import com.alura.forum.domain.modelo.Curso;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Curso toDomainObject(CursoInput cursoInput){
        return modelMapper.map(cursoInput, Curso.class);
    }

    public void copyToDomainObject(CursoInput cursoInput, Curso curso){
        modelMapper.map(cursoInput, curso);
    }

}

