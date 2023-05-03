package com.alura.forum.api.assembler.topicoAssemblers;

import com.alura.forum.api.model.topico.TopicoInput;
import com.alura.forum.domain.modelo.Topico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Topico toDomainObject(TopicoInput topicoInput){
        return modelMapper.map(topicoInput, Topico.class);
    }

    public void copyToDomainObject(TopicoInput topicoInput, Topico topico){
        modelMapper.map(topicoInput,topico);
    }
}
