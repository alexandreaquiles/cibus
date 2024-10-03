package br.com.cibus.tipodecozinha;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoDeCozinhaResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    public TipoDeCozinhaResponse(TipoDeCozinha tipoDeCozinha) {
        this(tipoDeCozinha.getId(), tipoDeCozinha.getNome());
    }

    public TipoDeCozinhaResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
