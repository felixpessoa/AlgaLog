package com.algaworks.algalog.api.domain.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.api.domain.exception.NegocioException;
import com.algaworks.algalog.api.domain.model.Cliente;
import com.algaworks.algalog.api.domain.model.Entrega;
import com.algaworks.algalog.api.domain.model.StatusEntrega;
import com.algaworks.algalog.api.domain.repository.ClienteRepository;
import com.algaworks.algalog.api.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private CatalogoClienteService clienteService;

	@Transactional
	public Entrega solicitar (Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId()); 
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PEDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
	
	
	
	
}
