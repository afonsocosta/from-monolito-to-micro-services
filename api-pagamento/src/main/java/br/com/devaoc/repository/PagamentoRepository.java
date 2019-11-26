package br.com.devaoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.devaoc.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
