package br.com.banco.repositories;
import br.com.banco.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

    List<Transferencia> findAllByContaId(Integer contaId);

    List<Transferencia> findAllByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

    List<Transferencia> findAllByDataTransferenciaBetweenAndOperadorTransacao(LocalDateTime dataInicio, LocalDateTime dataFim, String operadorTransacao);

    List<Transferencia> findAllByOperadorTransacao(String operadorTransacao);

    boolean existsByContaId(Integer contaId);
}
