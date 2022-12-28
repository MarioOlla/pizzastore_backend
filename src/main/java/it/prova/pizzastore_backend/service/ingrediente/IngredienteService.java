package it.prova.pizzastore_backend.service.ingrediente;

import java.util.List;

import it.prova.pizzastore_backend.model.Ingrediente;

public interface IngredienteService {
	public List<Ingrediente> listAll();

	public Ingrediente caricaSingoloElemento(Long id);

	public Ingrediente aggiorna(Ingrediente ruoloInstance);

	public Ingrediente inserisciNuovo(Ingrediente ruoloInstance);

	public void rimuovi(Long idToRemove);

	public Ingrediente cercaPerDescrizione(String descrizione);
}
