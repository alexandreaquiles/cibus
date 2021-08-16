package br.com.cibus.tipodecozinha;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record TipoDeCozinhaParaAdicaoForm(@NotBlank @Size(min = 1, max = 50) String nome) {

    TipoDeCozinha toEntity() {
        return new TipoDeCozinha(this.nome);
    }

}
