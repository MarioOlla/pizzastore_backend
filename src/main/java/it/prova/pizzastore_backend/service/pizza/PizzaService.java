package it.prova.pizzastore_backend.service.pizza;

import java.util.List;

import it.prova.pizzastore_backend.model.Pizza;

public interface PizzaService {
	
	public List<Pizza> listAll();

	public Pizza caricaSingoloElemento(Long id);

	public Pizza aggiorna(Long id ,Pizza pizzaInstance);

	public Pizza inserisciNuovo(Pizza pizzaInstance);

	public void rimuovi(Long idToRemove);

	public Pizza cercaPerDescrizione(String descrizione);
}
