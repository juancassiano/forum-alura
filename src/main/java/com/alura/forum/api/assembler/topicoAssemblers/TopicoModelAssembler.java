package com.alura.forum.api.assembler.topicoAssemblers;

import com.alura.forum.api.model.topico.TopicoModel;
import com.alura.forum.domain.modelo.Topico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TopicoModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public TopicoModel toModel(Topico topico){
        return modelMapper.map(topico, TopicoModel.class);
    }

    public Page<TopicoModel> toPageModel(Page<Topico> topicos){
        return topicos.map(this::toModel);
    }
}