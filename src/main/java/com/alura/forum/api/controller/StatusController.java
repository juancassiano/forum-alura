package com.alura.forum.api.controller;

import com.alura.forum.domain.services.CadastroSolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos/{topicoCodigo}/status")
public class StatusController {

    @Autowired
    private CadastroSolucaoService cadastroSolucaoService;

    @PutMapping("/resolver")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resolver(@PathVariable String topicoCodigo){
        cadastroSolucaoService.resolver(topicoCodigo);
    }
    @PutMapping("/fechar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void fechar(@PathVariable String topicoCodigo){
        cadastroSolucaoService.fechar(topicoCodigo);
    }
    @PutMapping("/responder")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void responder(@PathVariable String topicoCodigo){
        cadastroSolucaoService.responder(topicoCodigo);
    }

}
