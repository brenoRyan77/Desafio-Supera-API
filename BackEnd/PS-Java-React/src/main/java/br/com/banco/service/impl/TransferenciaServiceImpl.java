package br.com.banco.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;
import br.com.banco.utils.Utilidades;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferenciaServiceImpl implements TransferenciaService {

	@Autowired
	TransferenciaRepository repository;

	@Override
	public List<Transferencia> consultarTransacoes(TransferenciaDTO dtoFom) throws Exception {

		List<Transferencia> listaRetorno = new ArrayList<>();
		
		LocalDateTime dtAtual = null;
		LocalDateTime dtFinal = null;

		String nomeOperador = dtoFom.getNomeOperador();
		if (nomeOperador != null) {
			nomeOperador = nomeOperador.trim();
		}
		
		if(!Utilidades.ehNullOuVazio(dtoFom.getDataInicial())) {
			dtAtual = Utilidades.formatarHoraBanco(dtoFom.getDataInicial());
		}
		
		if(!Utilidades.ehNullOuVazio(dtoFom.getDataFinal())) {
			dtFinal = Utilidades.formatarHoraBanco(dtoFom.getDataFinal());
		}
		
		listaRetorno = repository.buscarTransacoesComFiltro(dtAtual, dtFinal, nomeOperador);
		
		return listaRetorno;
	}

}
