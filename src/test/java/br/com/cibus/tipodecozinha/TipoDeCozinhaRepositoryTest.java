package br.com.cibus.tipodecozinha;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class TipoDeCozinhaRepositoryTest {

    @Autowired
    private TipoDeCozinhaRepository tipoDeCozinhaRepository;

    @Test
    void deve_listar_os_nomes_em_ordem_alfabetica() {
        // Árabe, Baiana, Chinesa e Italiana já vem cadastradas
        tipoDeCozinhaRepository.saveAll(
                List.of(new TipoDeCozinha("Mexicana"),
                        new TipoDeCozinha("coreana"),
                        new TipoDeCozinha("Alemã")));


        List<TipoDeCozinha> tiposDeCozinha = tipoDeCozinhaRepository.findByOrderByNomeAsc();

        assertThat(tiposDeCozinha).hasSize(7);
        assertThat(tiposDeCozinha)
                .extracting(TipoDeCozinha::getNome)
                .containsExactly("Alemã", "Árabe", "Baiana", "Chinesa", "coreana", "Italiana", "Mexicana");
    }

}
