package br.com.banco.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransferenciaDTO {

	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private String nomeOperador;
}
