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

import it.prova.pizzastore_backend.dto.PizzaDTO;
import it.prova.pizzastore_backend.service.pizza.PizzaService;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public List<PizzaDTO> listAll(){
		return PizzaDTO.buildDTOListFromModelList(pizzaService.listAll());
	}
	
	@GetMapping("/{id}")
	public PizzaDTO findById(@PathVariable(name = "id", required = true) Long id) {
		return PizzaDTO.buildDTOFromModel(pizzaService.caricaSingoloElemento(id));
	}
	
	@PostMapping
	public PizzaDTO inserisci(@RequestBody @Valid PizzaDTO input) {
		return PizzaDTO.buildDTOFromModel(pizzaService.inserisciNuovo(input.buildModelFromDTO()));
	}
	
	@PutMapping("/{id}")
	public PizzaDTO aggiorna (@PathVariable(name = "id", required = true) Long id ,@RequestBody @Valid PizzaDTO input) {
		return PizzaDTO.buildDTOFromModel(pizzaService.aggiorna( id,input.buildModelFromDTO()));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable(name = "id", required = true) Long id) {
		pizzaService.rimuovi(id);
	}
}
