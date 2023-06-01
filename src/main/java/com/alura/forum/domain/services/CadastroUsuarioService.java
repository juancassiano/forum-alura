package com.alura.forum.domain.services;

import com.alura.forum.domain.modelo.Usuario;
import com.alura.forum.domain.modelo.exception.UsuarioEmUsoException;
import com.alura.forum.domain.modelo.exception.UsuarioNaoEncontradoException;
import com.alura.forum.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        Optional<Usuario> usuarioEmailExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuarioEmailExistente.isPresent()){
            throw new UsuarioEmUsoException(usuario.getEmail());
        }
        return usuarioRepository.save(usuario);

    }

    public Usuario buscar(String usuarioCodigo){
        return usuarioRepository.findByCodigo(usuarioCodigo).orElseThrow(
                () -> new UsuarioNaoEncontradoException(usuarioCodigo)
        );
    }

}
