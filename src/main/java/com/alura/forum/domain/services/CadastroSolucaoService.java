package com.alura.forum.domain.services;

import com.alura.forum.domain.modelo.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroSolucaoService {

    @Autowired
    private CadastroTopicoService cadastrarTopicoService;

    @Transactional
    public void resolver(String topicoCodigo){
        Topico topico = cadastrarTopicoService.buscar(topicoCodigo);
        topico.resolver();
    }
    @Transactional
    public void fechar(String topicoCodigo){
        Topico topico = cadastrarTopicoService.buscar(topicoCodigo);
        topico.fechar();
    }
    @Transactional
    public void responder(String topicoCodigo){
        Topico topico = cadastrarTopicoService.buscar(topicoCodigo);
        topico.responder();
    }
}
