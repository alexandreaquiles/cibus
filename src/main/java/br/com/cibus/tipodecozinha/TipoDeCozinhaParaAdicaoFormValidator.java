package br.com.cibus.tipodecozinha;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TipoDeCozinhaParaAdicaoFormValidator implements Validator {

    private final TipoDeCozinhaRepository tipoDeCozinhaRepository;

    public TipoDeCozinhaParaAdicaoFormValidator(TipoDeCozinhaRepository tipoDeCozinhaRepository) {
        this.tipoDeCozinhaRepository = tipoDeCozinhaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return TipoDeCozinhaParaAdicaoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TipoDeCozinhaParaAdicaoForm form = (TipoDeCozinhaParaAdicaoForm) target;
        if(tipoDeCozinhaRepository.existsByNome(form.nome())) {
            errors.rejectValue("nome", "tipo.de.cozinha.nome.ja.existente");
        }
    }

}
