package com.alura.forum.api.controller;

import com.alura.forum.api.assembler.topicoAssemblers.TopicoInputDisassembler;
import com.alura.forum.api.assembler.topicoAssemblers.TopicoModelAssembler;
import com.alura.forum.api.model.topico.TopicoInput;
import com.alura.forum.api.model.topico.TopicoModel;
import com.alura.forum.domain.modelo.Topico;
import com.alura.forum.domain.modelo.exception.TopicoNaoEncontradoException;
import com.alura.forum.domain.repository.TopicoRepository;
import com.alura.forum.domain.services.CadastroTopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoModelAssembler topicoModelAssembler;

    @Autowired
    private TopicoInputDisassembler topicoInputDisassembler;

    @Autowired
    private CadastroTopicoService cadastrarTopicoService;


    @GetMapping
    public Page<TopicoModel> listar(@PageableDefault(sort="dataCriacao", direction = Sort.Direction.ASC, size=10)Pageable pageable){
        Page<Topico> todosTopicos = topicoRepository.findAll(pageable);
        return topicoModelAssembler.toPageModel(todosTopicos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TopicoModel salvar(@Valid @RequestBody TopicoInput topicoInput){
        Topico topico = topicoInputDisassembler.toDomainObject(topicoInput);
        topico = cadastrarTopicoService.salvar(topico);
        return topicoModelAssembler.toModel(topico);
    }

    @GetMapping("/{topicoCodigo}")
    public TopicoModel buscar(@PathVariable String topicoCodigo){
            Topico topico = cadastrarTopicoService.buscar(topicoCodigo);

            return topicoModelAssembler.toModel(topico);
    }

    @Transactional
    @PutMapping("/{topicoCodigo}")
    public TopicoModel atualizar(@PathVariable String topicoCodigo, @RequestBody @Valid TopicoInput topicoInput){

        try{
            Topico topicoAtual = cadastrarTopicoService.buscar(topicoCodigo);
            Topico topicoAtualizado = topicoInputDisassembler.toDomainObject(topicoInput);
            topicoAtualizado.setCodigo(topicoCodigo);
            topicoAtual = cadastrarTopicoService.atualizar(topicoCodigo,topicoAtualizado);
            return topicoModelAssembler.toModel(topicoAtual);

        }catch (TopicoNaoEncontradoException e){
            throw new TopicoNaoEncontradoException(e.getMessage());
        }
    }

    @DeleteMapping("/{topicoCodigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String topicoCodigo){
        cadastrarTopicoService.excluir(topicoCodigo);
    }

}
