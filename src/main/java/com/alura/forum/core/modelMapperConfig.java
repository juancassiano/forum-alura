package com.alura.forum.core;

import com.alura.forum.api.model.resposta.RespostaInput;
import com.alura.forum.domain.modelo.Resposta;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(RespostaInput.class, Resposta.class)
//                .addMappings(mapper -> mapper.skip(Resposta::setId));

        return modelMapper;
    }
}
