package br.com.cibus.tipodecozinha;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

/**
 * @see https://martinfowler.com/articles/mocksArentStubs.html
 */
class TipoDeCozinhaParaEdicaoFormValidatorTest {

    private TipoDeCozinhaParaEdicaoFormValidator formValidator;
    private TipoDeCozinhaRepository repository;
    private Errors errors;

    @BeforeEach
    void setUp() {
        repository = mock(TipoDeCozinhaRepository.class); // stub
        when(repository.existsByNomeWithDifferentId(eq("Mexicana"), not(eq(1L)))).thenReturn(true);

        formValidator = new TipoDeCozinhaParaEdicaoFormValidator(repository);
        errors = mock(Errors.class); // mock
    }

    @Test
    void nao_deve_dar_erro_quando_nome_ja_existe_e_id_for_o_mesmo() {
        var form = new TipoDeCozinhaParaEdicaoForm
                .TipoDeCozinhaParaEdicaoFormBuilder()
                .id(1L)
                .nome("Mexicana")
                .build();

        formValidator.validate(form, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void deve_dar_erro_quando_o_nome_ja_existe_mas_id_for_diferente() {
        var form = new TipoDeCozinhaParaEdicaoForm
                .TipoDeCozinhaParaEdicaoFormBuilder()
                .id(999L)
                .nome("Mexicana")
                .build();

        formValidator.validate(form, errors);

        verify(errors).rejectValue("nome", "tipo.de.cozinha.nome.ja.existente");
    }

    @Test
    void nao_deve_dar_erro_quando_nome_nao_existe_para_o_id() {
        var form = new TipoDeCozinhaParaEdicaoForm
                .TipoDeCozinhaParaEdicaoFormBuilder()
                .id(1L)
                .nome("Italiana")
                .build();

        formValidator.validate(form, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }

    @Test
    void nao_deve_dar_erro_quando_nome_nao_existe_e_id_eh_diferente() {
        var form = new TipoDeCozinhaParaEdicaoForm
                .TipoDeCozinhaParaEdicaoFormBuilder()
                .id(99L)
                .nome("Italiana")
                .build();

        formValidator.validate(form, errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}