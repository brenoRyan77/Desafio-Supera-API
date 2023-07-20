package br.com.banco.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.entities.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

	@Query("SELECT t FROM Transferencia t WHERE " 
			+ "(:dataInicio IS NULL OR t.dataTransferencia >= :dataInicio) AND "
			+ "(:dataFim IS NULL OR t.dataTransferencia <= :dataFim) AND "
			+ "(:nomeOperador IS NULL OR t.nomeOperadorTransacao = :nomeOperador)")
	List<Transferencia> buscarTransacoesComFiltro(@Param("dataInicio") LocalDateTime dataInicio,
			@Param("dataFim") LocalDateTime dataFim, @Param("nomeOperador") String nomeOperador);
}
