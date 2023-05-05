package com.alura.forum.api.controller;

import com.alura.forum.api.assembler.respostaAssemblers.RespostaInputDisassembler;
import com.alura.forum.api.assembler.respostaAssemblers.RespostaModelAssembler;
import com.alura.forum.api.model.resposta.RespostaInput;
import com.alura.forum.api.model.resposta.RespostaModel;
import com.alura.forum.domain.modelo.Resposta;
import com.alura.forum.domain.modelo.Topico;
import com.alura.forum.domain.modelo.Usuario;
import com.alura.forum.domain.modelo.exception.EntidadeNaoEncontradoException;
import com.alura.forum.domain.modelo.exception.RespostaNaoEncontradaException;
import com.alura.forum.domain.modelo.exception.UsuarioNaoEncontradoException;
import com.alura.forum.domain.repository.RespostaRepository;
import com.alura.forum.domain.services.CadastroRespostaService;
import com.alura.forum.domain.services.CadastroTopicoService;
import com.alura.forum.domain.services.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos/{topicoCodigo}/respostas")
public class RespostaController {

    @Autowired
    private CadastroTopicoService cadastroTopicoService;
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private CadastroRespostaService cadastroRespostaService;
    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private RespostaModelAssembler respostaModelAssembler;
    @Autowired
    private RespostaInputDisassembler respostaInputDisassembler;

    @GetMapping
    public List<RespostaModel> listar(@PathVariable String topicoCodigo){
        Topico topico = cadastroTopicoService.buscar(topicoCodigo);
        return respostaModelAssembler.toCollectionModel(topico.getRespostas());
    }

    @GetMapping("/{respostaId}")
    public RespostaModel buscar(@PathVariable String topicoCodigo,@PathVariable Long respostaId){
        Resposta resposta = cadastroRespostaService.buscar(respostaId);
        return respostaModelAssembler.toModel(resposta);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaModel adicioncar(@PathVariable String topicoCodigo, @RequestBody @Valid RespostaInput respostaInput){
            Topico topico = cadastroTopicoService.buscar(topicoCodigo);
            Usuario usuario = cadastroUsuarioService.buscar(respostaInput.getCodigoAutor());

            Resposta resposta = respostaInputDisassembler.toDomainObject(respostaInput);
            resposta.setAutor(usuario);
            resposta.setTopico(topico);
            resposta = cadastroRespostaService.salvar(resposta);
            return respostaModelAssembler.toModel(resposta);
    }

    @PutMapping("/{respostaId}")
    public RespostaModel atualizar(@PathVariable String topicoCodigo, @PathVariable Long respostaId, @RequestBody @Valid RespostaInput respostaInput){
        Usuario usuario = cadastroUsuarioService.buscar(respostaInput.getCodigoAutor());
        Resposta respostaAtual = cadastroRespostaService.buscar(respostaId);
        respostaInputDisassembler.copyToDomainObject(respostaInput, respostaAtual);
        respostaAtual.setAutor(usuario);
        respostaAtual = cadastroRespostaService.salvar(respostaAtual);
        return respostaModelAssembler.toModel(respostaAtual);
    }

    @DeleteMapping("/{respostaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String topicoCodigo, @PathVariable Long respostaId){
        cadastroRespostaService.excluir(respostaId);
    }

}
