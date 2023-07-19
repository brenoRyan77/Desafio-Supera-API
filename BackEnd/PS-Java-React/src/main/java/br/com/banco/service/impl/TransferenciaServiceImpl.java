package br.com.banco.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransaferenciaRepository;
import br.com.banco.service.TransferenciaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	TransaferenciaRepository repository;

	@Override
	public List<Transferencia> consultarTransacoes(TransferenciaDTO dtoFom) {

		List<Transferencia> listaRetorno = new ArrayList<>();
		
		String nomeOperador = dtoFom.getNomeOperador();
		if(nomeOperador != null) {
			nomeOperador = nomeOperador.trim();
		}
		
		listaRetorno = repository.buscarTransacoesComFiltro(
				dtoFom.getDataInicial(), dtoFom.getDataFinal(), nomeOperador);
		
		return listaRetorno;
	}

}
