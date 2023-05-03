package com.alura.forum.api.controller;

import com.alura.forum.api.assembler.usuarioAssemblers.UsuarioInputDisassembler;
import com.alura.forum.api.assembler.usuarioAssemblers.UsuarioModelAssembler;
import com.alura.forum.api.model.UsuarioModel;
import com.alura.forum.api.model.input.UsuarioInput;
import com.alura.forum.domain.modelo.Usuario;
import com.alura.forum.domain.repository.UsuarioRepository;
import com.alura.forum.domain.services.CadastroUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CadastroUsuarioService cadastroUsuariosService;

    @Autowired
    private UsuarioModelAssembler usuarioModelAssembler;
    @Autowired
    private UsuarioInputDisassembler usuarioInputDisassembler;


    @GetMapping
    public List<UsuarioModel> listar(){
        List<Usuario> todosUsuario = usuarioRepository.findAll();

        return usuarioModelAssembler.toCollectionModel(todosUsuario);
    }

    @GetMapping("/{usuarioCodigo}")
    public UsuarioModel buscar(@PathVariable String usuarioCodigo){
        Usuario usuario = cadastroUsuariosService.buscar(usuarioCodigo);

        return usuarioModelAssembler.toModel(usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel salvar(@RequestBody @Valid UsuarioInput usuarioInput){
        Usuario usuario = usuarioInputDisassembler.toDomainObject(usuarioInput);
        usuario = cadastroUsuariosService.salvar(usuario);

        return usuarioModelAssembler.toModel(usuario);
    }


}
