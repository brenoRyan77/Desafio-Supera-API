package br.com.banco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.service.TransferenciaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/transferencia")
@Tag(description = "Responsável por todas as operações relacionadas a Transferência", name = "Transferência")
public class TransferenciaController {

	@Autowired
	private TransferenciaService service;
	
	@GetMapping()
	public ResponseEntity<List<Transferencia>> consultarTransferencia(@RequestBody TransferenciaDTO dtoForm) throws Exception {
		
		List<Transferencia> retorno = service.consultarTransacoes(dtoForm);
		return ResponseEntity.ok(retorno);
		
	}
}
