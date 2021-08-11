package br.com.cibus.tipodecozinha;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TipoDeCozinhaParaEdicaoFormValidator implements Validator  {

    private final TipoDeCozinhaRepository tipoDeCozinhaRepository;

    public TipoDeCozinhaParaEdicaoFormValidator(TipoDeCozinhaRepository tipoDeCozinhaRepository) {
        this.tipoDeCozinhaRepository = tipoDeCozinhaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return TipoDeCozinhaParaEdicaoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TipoDeCozinhaParaEdicaoForm form = (TipoDeCozinhaParaEdicaoForm) target;
        if (tipoDeCozinhaRepository.existsByNomeWithDifferentId(form.getNome(), form.getId())) {
            errors.rejectValue("nome", "tipo.de.cozinha.nome.ja.existente");
        }
    }
}
