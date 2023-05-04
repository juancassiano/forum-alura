package com.alura.forum.domain.services;

import com.alura.forum.domain.modelo.Curso;
import com.alura.forum.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CadastroCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }

    @Transactional
    public void excluir(String cursoCodigo){
        try{
           Curso curso = buscar(cursoCodigo);
           Long cursoId = curso.getId();
           cursoRepository.deleteById(cursoId);

        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    public Curso buscar(String cursoNome){
        return cursoRepository.findByNome(cursoNome).orElseThrow(
                () -> new RuntimeException("Curso não encontrado")
        );
    }

}
