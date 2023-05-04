package com.alura.forum.domain.modelo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String codigo;

    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensagem;

    @CreationTimestamp
    private OffsetDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne
    private Usuario autor;
    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy="topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<Resposta>();

    @PrePersist
    private void gerarCodigo(){
        setCodigo(UUID.randomUUID().toString());
    }

    public void resolver(){
        setStatus(StatusTopico.SOLUCIONADO);
    }
    public void fechar(){
        setStatus(StatusTopico.FECHADO);
    }

    public void responder(){
        setStatus(StatusTopico.NAO_SOLUCIONADO);
    }


}
