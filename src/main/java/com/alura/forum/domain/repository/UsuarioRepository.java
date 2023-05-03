package com.alura.forum.domain.repository;

import com.alura.forum.domain.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByCodigo(String codigo);

    Optional<Usuario> findByEmail(String email);
}
