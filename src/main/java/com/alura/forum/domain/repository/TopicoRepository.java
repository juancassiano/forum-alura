package com.alura.forum.domain.repository;

import com.alura.forum.domain.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByCodigo(String codigo);

}
