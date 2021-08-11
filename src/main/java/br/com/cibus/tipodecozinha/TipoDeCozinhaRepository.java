package br.com.cibus.tipodecozinha;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDeCozinhaRepository extends JpaRepository<TipoDeCozinha, Long> {
    List<TipoDeCozinha> findByOrderByNomeAsc();

    boolean existsByNome(String nome);

    @Deprecated
    boolean existsByNomeAndIdNot(String nome, Long id);

    default boolean existsByNomeWithDifferentId(String nome, Long id) {
        return existsByNomeAndIdNot(nome, id);
    }
}
