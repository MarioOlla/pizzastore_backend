package it.prova.pizzastore_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.pizzastore_backend.dto.IntervalloDate;
import it.prova.pizzastore_backend.dto.StatsOutput;
import it.prova.pizzastore_backend.service.ordine.OrdineService;

@RestController
@RequestMapping("/api/proprietario")
public class ProprietarioController {
	@Autowired
	private OrdineService service;

	@GetMapping()
	public StatsOutput statistiche(@RequestBody IntervalloDate intervallo) {
		return service.getStats(intervallo);
	}

}
