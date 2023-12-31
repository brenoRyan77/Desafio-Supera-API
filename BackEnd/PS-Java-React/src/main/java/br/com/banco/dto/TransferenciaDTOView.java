package br.com.banco.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransferenciaDTOView {

	private Long transferenciaId;
    private LocalDateTime dataTransferencia;
    private BigDecimal valor;
    private String tipo;
    private String nomeOperadorTransacao;
    private Long contaId;
    private String nomeResponsavel;
}
