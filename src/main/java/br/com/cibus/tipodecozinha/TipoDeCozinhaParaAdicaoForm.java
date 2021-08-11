package br.com.cibus.tipodecozinha;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

class TipoDeCozinhaParaAdicaoForm {

    @NotBlank
    @Size(min=1, max = 50)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    TipoDeCozinha toEntity() {
        return new TipoDeCozinha(this.nome);
    }
}
