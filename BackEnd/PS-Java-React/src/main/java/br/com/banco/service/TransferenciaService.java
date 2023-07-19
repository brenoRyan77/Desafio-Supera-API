package br.com.banco.service;

import java.util.List;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.dto.TransferenciaDTOView;
import br.com.banco.entities.Transferencia;

public interface TransferenciaService {

	List<Transferencia> consultarTransacoes(TransferenciaDTO dtoFom);
}
