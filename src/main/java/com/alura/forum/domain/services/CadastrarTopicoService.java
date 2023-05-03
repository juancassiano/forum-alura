package com.alura.forum.domain.services;

import com.alura.forum.api.model.topico.TopicoInput;
import com.alura.forum.domain.modelo.Curso;
import com.alura.forum.domain.modelo.Topico;
import com.alura.forum.domain.modelo.Usuario;
import com.alura.forum.domain.repository.CursoRepository;
import com.alura.forum.domain.repository.TopicoRepository;
import com.alura.forum.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CadastrarTopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CadastroCursoService cadastroCursoService;
    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Transactional
    public Topico salvar(Topico topico){
       String usuarioCodigo = topico.getAutor().getCodigo();
       Usuario usuario = cadastroUsuarioService.buscar(usuarioCodigo);

       String nomeCurso = topico.getCurso().getNome();
       Curso curso = cadastroCursoService.buscar(nomeCurso);
       topico.setAutor(usuario);
       topico.setCurso(curso);
       verificarExistenciaTopico(topico);

       return topicoRepository.save(topico);
    }
    private void verificarExistenciaTopico(Topico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensagem(topico.getTitulo(), topico.getMensagem());
        if (topicoExistente.isPresent()) {
            throw new RuntimeException("Já existe um tópico com o mesmo título e mensagem");
        }
    }


    public Topico buscar(String topicoCodigo){
        return topicoRepository.findByCodigo(topicoCodigo).orElseThrow(
                () -> new RuntimeException("Tópico não encontrado")
        );
    }
}
