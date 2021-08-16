package br.com.cibus.tipodecozinha;

import lombok.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;
import java.util.function.LongFunction;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class TipoDeCozinhaParaEdicaoForm {

    @NotNull
    @Min(1)
    private Long id;

    @NotBlank
    @Size(min=1, max = 50)
    private String nome;

    TipoDeCozinha toEntity(LongFunction<Optional<TipoDeCozinha>> buscadorDeTipoDeCozinha) {
        TipoDeCozinha tipoDeCozinha = buscadorDeTipoDeCozinha.apply(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        tipoDeCozinha.setNome(nome);
        return tipoDeCozinha;
    }

}
