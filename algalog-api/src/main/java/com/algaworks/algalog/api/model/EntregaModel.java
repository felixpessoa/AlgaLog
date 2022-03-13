package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaModel {

	private Long id;
	
	private ClienteModel cliente;
	
	private DestinatarioModel destinatario; 
	
	private BigDecimal taxa;
	
	private StatusEntrega status;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataPedido;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFinalizacao;
}
