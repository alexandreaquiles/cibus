package br.com.cibus;

import br.com.cibus.tipodecozinha.RestaurantesPorTipoDeCozinha;
import br.com.cibus.tipodecozinha.TipoDeCozinhaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TipoDeCozinhaRepositoryTest {

    @Autowired
    private TipoDeCozinhaRepository tipoDeCozinhaRepository;

    @Test
    void deveContarTotalDeRestaurantesPorTipoDeCozinha() {
        List<RestaurantesPorTipoDeCozinha> relatorio = tipoDeCozinhaRepository.contaRestaurantesPorTipoDeCozinha();
        assertThat(relatorio).hasSize(4);
        assertThat(relatorio)
                .extracting(RestaurantesPorTipoDeCozinha::getNomeDoTipoDeCozinha, RestaurantesPorTipoDeCozinha::getTotalDeRestaurantes)
                .containsExactly(tuple("Árabe", 3L), tuple("Baiana", 2L), tuple("Chinesa", 3L), tuple("Italiana", 4L));
    }

}
