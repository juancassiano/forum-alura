package com.alura.forum.api.assembler.respostaAssemblers;

import com.alura.forum.api.model.resposta.RespostaInput;
import com.alura.forum.domain.modelo.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespostaInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Resposta toDomainObject(RespostaInput respostaInput){
        return modelMapper.map(respostaInput, Resposta.class);
    }

    public void copyToDomainObject(RespostaInput respostaInput ,Resposta resposta){
        modelMapper.map(respostaInput, resposta);
    }
}
