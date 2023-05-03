package com.alura.forum.domain.services;

import com.alura.forum.domain.modelo.Usuario;
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
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if(usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)){
            throw new RuntimeException(
                    String.format("Já existe um usuário cadastrado com o email: %s", usuario.getEmail())
            );
        }
        return usuarioRepository.save(usuario);

    }

    public Usuario buscar(String usuarioCodigo){
        return usuarioRepository.findByCodigo(usuarioCodigo).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

}
