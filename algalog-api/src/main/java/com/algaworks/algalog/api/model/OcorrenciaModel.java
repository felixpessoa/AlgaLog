package com.algaworks.algalog.api.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModel {
	
	private Long id;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataRegistro;

}
