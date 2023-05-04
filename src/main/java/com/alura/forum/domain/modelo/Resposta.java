package com.alura.forum.domain.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String mensagem;
    @ManyToOne
    private Topico topico;
    @CreationTimestamp
    private OffsetDateTime dataCriacao;
    @ManyToOne
    private Usuario autor;
    @Column(nullable = false)
    private Boolean solucao = Boolean.FALSE;
}
