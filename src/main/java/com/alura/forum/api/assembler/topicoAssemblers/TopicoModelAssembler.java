package com.alura.forum.api.assembler.topicoAssemblers;

import com.alura.forum.api.model.topico.TopicoModel;
import com.alura.forum.domain.modelo.Topico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopicoModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public TopicoModel toModel(Topico topico){
        return modelMapper.map(topico, TopicoModel.class);
    }

    public List<TopicoModel> toCollectionModel(List<Topico> topicos){
        return topicos.stream().map(topico -> toModel(topico))
                .collect(Collectors.toList());
    }
}
