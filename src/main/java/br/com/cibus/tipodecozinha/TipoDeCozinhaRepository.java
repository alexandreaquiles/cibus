package br.com.cibus.tipodecozinha;

import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface TipoDeCozinhaRepository extends JpaRepository<TipoDeCozinha, Long> {

    @Query(value = "SELECT tc.nome AS nomeDoTipoDeCozinha, COUNT(r.id) AS totalDeRestaurantes FROM tipo_de_cozinha tc LEFT JOIN restaurante r ON tc.id=r.tipo_de_cozinha_id GROUP BY tc.id ORDER BY tc.nome", nativeQuery = true)
    List<RestaurantesPorTipoDeCozinha> contaRestaurantesPorTipoDeCozinha();

}