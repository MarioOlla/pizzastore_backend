package it.prova.pizzastore_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore_backend.dto.ClienteDTO;
import it.prova.pizzastore_backend.service.cliente.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public List<ClienteDTO> listAll(){
		return ClienteDTO.buildDTOListFromModelList(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable(name = "id", required = true) Long id) {
		return ClienteDTO.buildDTOFromModel(service.caricaSingoloElemento(id));
	}
	
	@PostMapping
	public ClienteDTO inserisci(@RequestBody @Valid ClienteDTO input) {
		return ClienteDTO.buildDTOFromModel(service.inserisciNuovo(input.buildModelFromDTO()));
	}
	
	@PutMapping("/{id}")
	public ClienteDTO aggiorna (@PathVariable(name = "id", required = true) Long id ,@RequestBody @Valid ClienteDTO input) {
		return ClienteDTO.buildDTOFromModel(service.aggiorna( id,input.buildModelFromDTO()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable(name = "id", required = true) Long id) {
		service.rimuovi(id);
	}
}
