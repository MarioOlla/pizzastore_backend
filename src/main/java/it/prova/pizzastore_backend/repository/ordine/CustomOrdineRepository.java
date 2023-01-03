package it.prova.pizzastore_backend.repository.ordine;

import java.util.List;

import it.prova.pizzastore_backend.model.Ordine;

public interface CustomOrdineRepository {
	
	public List<Ordine> findByExample(Ordine example);
}
