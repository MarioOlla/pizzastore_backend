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

import it.prova.pizzastore_backend.dto.OrdineDTO;
import it.prova.pizzastore_backend.service.ordine.OrdineService;

@RestController
@RequestMapping("/api/ordine")
public class OrdineController {
	
	@Autowired
	private OrdineService service;
	
	@GetMapping
	public List<OrdineDTO> listAll(){
		return OrdineDTO.buildDTOListFromModelList(service.listAll());
	}
	
	@GetMapping("/{id}")
	public OrdineDTO findById(@PathVariable(name = "id", required = true) Long id) {
		return OrdineDTO.buildDTOFromModel(service.caricaSingoloElemento(id));
	}
	
	@PostMapping
	public OrdineDTO inserisci(@RequestBody @Valid OrdineDTO input) {
		return OrdineDTO.buildDTOFromModel(service.inserisciNuovo(input.buildModelFromDTO()));
	}
	
	@PutMapping("/{id}")
	public OrdineDTO aggiorna (@PathVariable(name = "id", required = true) Long id ,@RequestBody @Valid OrdineDTO input) {
		return OrdineDTO.buildDTOFromModel(service.aggiorna( id,input.buildModelFromDTO()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable(name = "id", required = true) Long id) {
		service.rimuovi(id);
	}
	
}
