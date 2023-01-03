package it.prova.pizzastore_backend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore_backend.dto.OrdineDTO;
import it.prova.pizzastore_backend.service.ordine.OrdineService;

@RestController
@RequestMapping("/api/fattorino")
public class FattorinoController {
	
	@Autowired
	private OrdineService service;
	
	@GetMapping("/list")
	public List<OrdineDTO> listaOrdiniDi(Principal p){
		return OrdineDTO.buildDTOListFromModelList(service.listaOrdiniDi(p.getName()));
	}
	
	@PutMapping("/{id}")
	public OrdineDTO chiudiOrdine(@PathVariable(name = "id", required = true)Long id) {
		return OrdineDTO.buildDTOFromModel(service.chiudiOrdine(id));
	}
}
