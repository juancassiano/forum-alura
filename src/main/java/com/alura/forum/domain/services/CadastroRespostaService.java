package com.alura.forum.domain.services;

import com.alura.forum.domain.modelo.Resposta;
import com.alura.forum.domain.modelo.exception.RespostaNaoEncontradaException;
import com.alura.forum.domain.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroRespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Transactional
    public Resposta salvar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    @Transactional
    public void excluir(Long respostaId){
        try{
            respostaRepository.deleteById(respostaId);
            respostaRepository.flush();
        }catch(EmptyResultDataAccessException e){
            throw new RespostaNaoEncontradaException(respostaId);
        }
    }

    public Resposta buscar(Long respostaId){
        return respostaRepository.findById(respostaId).orElseThrow(
                () -> new RespostaNaoEncontradaException(respostaId)
        );
    }
}
