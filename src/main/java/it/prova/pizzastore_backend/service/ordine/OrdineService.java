package it.prova.pizzastore_backend.service.ordine;

import java.util.List;

import it.prova.pizzastore_backend.model.Ordine;

public interface OrdineService {
	
	public List<Ordine> listAll();

	public Ordine caricaSingoloElemento(Long id);

	public Ordine aggiorna(Long id, Ordine ordineInstance);

	public Ordine inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Long idToRemove);

	public Ordine cercaPerCodice(String codice);
	
}
