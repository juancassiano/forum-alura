package com.alura.forum.domain.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = Boolean.FALSE;



}
