package it.prova.pizzastore_backend.repository;

import java.util.List;

import it.prova.pizzastore_backend.model.Utente;

public interface CustomUtenteRepository {
	
	public List<Utente> findByExample(Utente example);

}
