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

import it.prova.pizzastore_backend.dto.IngredienteDTO;
import it.prova.pizzastore_backend.service.ingrediente.IngredienteService;

@RestController
@RequestMapping("/api/ingrediente")
public class IngredienteController {
	
	@Autowired
	private IngredienteService service;
	
	@GetMapping
	public List<IngredienteDTO> listAll(){
		return IngredienteDTO.buildDTOListFromModelList(service.listAll());
	}
	
	@GetMapping("/{id}")
	public IngredienteDTO findById(@PathVariable(name = "id", required = true) Long id) {
		return IngredienteDTO.buildDTOFromModel(service.caricaSingoloElemento(id));
	}
	
	@PostMapping
	public IngredienteDTO inserisci(@RequestBody @Valid IngredienteDTO input) {
		return IngredienteDTO.buildDTOFromModel(service.inserisciNuovo(input.buildModelFromDTO()));
	}
	
	@PutMapping("/{id}")
	public IngredienteDTO aggiorna (@PathVariable(name = "id", required = true) Long id ,@RequestBody @Valid IngredienteDTO input) {
		return IngredienteDTO.buildDTOFromModel(service.aggiorna( id,input.buildModelFromDTO()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable(name = "id", required = true) Long id) {
		service.rimuovi(id);
	}
}
