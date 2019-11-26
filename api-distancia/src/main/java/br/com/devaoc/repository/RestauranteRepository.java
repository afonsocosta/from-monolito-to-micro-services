package br.com.devaoc.repository;

import br.com.devaoc.model.Restaurante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    Page<Restaurante> findAllByAprovadoAndTipoDeCozinhaId(boolean aprovado, Long tipoDeCozinhaId, Pageable limit);

    Page<Restaurante> findAllByAprovado(boolean aprovado, Pageable limit);
}
