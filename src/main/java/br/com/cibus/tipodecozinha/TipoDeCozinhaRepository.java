package br.com.cibus.tipodecozinha;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoDeCozinhaRepository extends JpaRepository<TipoDeCozinha, Long> {
    List<TipoDeCozinha> findByOrderByNomeAsc();
}
