package com.alura.forum.domain.modelo;

public enum StatusTopico {
    NAO_RESPONDIDO("Não Respondido"),
    NAO_SOLUCIONADO("Não Solucionado"),
    SOLUCIONADO("Solucionado"),
    FECHADO("Fechado");

    private String descricao;

    StatusTopico(String descricao){
        this.descricao = descricao;
    }
}
