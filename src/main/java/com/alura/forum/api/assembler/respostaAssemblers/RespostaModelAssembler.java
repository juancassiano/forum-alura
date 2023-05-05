package com.alura.forum.api.assembler.respostaAssemblers;

import com.alura.forum.api.model.resposta.RespostaModel;
import com.alura.forum.domain.modelo.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RespostaModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public RespostaModel toModel(Resposta resposta){
        return modelMapper.map(resposta, RespostaModel.class);
    }

    public List<RespostaModel> toCollectionModel(Collection<Resposta> respostas){
        return respostas.stream().map(resposta -> toModel(resposta))
                .collect(Collectors.toList());
    }


}
