package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.domain.model.Cliente;
import com.algaworks.algalog.api.domain.repository.ClienteRepository;
import com.algaworks.algalog.api.domain.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteRepository clienteRepository;
	private CatalogoClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Cliente> findById(@PathVariable (value = "id") Long id){
		return clienteRepository.findById(id)
//				.map(record -> ResponseEntity.ok(record))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
		
		//		Optional<Cliente> cliente = repository.findById(id);
//		
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
	}
	
	 
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@Valid @RequestBody Cliente cliente) {
//		return repository.save(cliente);
		return clienteService.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable (value = "id") Long id, @RequestBody Cliente cliente){
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
//		cliente = repository.save(cliente);
		cliente = clienteService.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable (value = "id") Long id){
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
//		repository.deleteById(id);
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
