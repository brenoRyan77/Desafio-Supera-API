package br.com.banco.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ConsultaDTO {

	private Long id;
    private LocalDateTime dataTransferencia;
    private Double valor;
    private String tipo;
    private String nomeOperadorTransacao;
    private Long contaId;
}
