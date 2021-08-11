package br.com.cibus.tipodecozinha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

class TipoDeCozinhaParaAdicaoFormValidatorTest {

    private TipoDeCozinhaRepository repository;
    private TipoDeCozinhaParaAdicaoFormValidator formValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        repository = mock(TipoDeCozinhaRepository.class);
        formValidator = new TipoDeCozinhaParaAdicaoFormValidator(repository);
        errors = mock(Errors.class);
    }

    @Test
    void quando_nome_ja_existe_deve_dar_erro() {
        when(repository.existsByNome("Mexicana")).thenReturn(true);

        var form = new TipoDeCozinhaParaAdicaoForm();
        form.setNome("Mexicana");

        formValidator.validate(form, errors);

        verify(errors).rejectValue("nome", "tipo.de.cozinha.nome.ja.existente");
    }

    @Test
    void quando_nome_nao_existe_nao_deve_dar_erro() {
        var form = new TipoDeCozinhaParaAdicaoForm();
        form.setNome("Francesa");

        formValidator.validate(form, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
   }

}