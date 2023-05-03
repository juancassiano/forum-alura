package com.alura.forum.api.controller;

import com.alura.forum.api.assembler.cursoAssemblers.CursoInputDisassembler;
import com.alura.forum.api.assembler.cursoAssemblers.CursoModelAssembler;
import com.alura.forum.api.model.curso.CursoInput;
import com.alura.forum.api.model.curso.CursoModel;
import com.alura.forum.domain.modelo.Curso;
import com.alura.forum.domain.repository.CursoRepository;
import com.alura.forum.domain.services.CadastroCursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoModelAssembler cursoModelAssembler;
    @Autowired
    private CursoInputDisassembler cursoInputDisassembler;
    @Autowired
    private CadastroCursoService cadastroCursoService;

    @GetMapping
    public List<CursoModel> listar(){
        List<Curso> todosCursos = cursoRepository.findAll();
        return cursoModelAssembler.toCollectionModel(todosCursos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoModel salvar(@RequestBody @Valid CursoInput cursoInput){
        Curso curso = cursoInputDisassembler.toDomainObject(cursoInput);
        curso = cadastroCursoService.salvar(curso);

        return cursoModelAssembler.toModel(curso);
    }
}
