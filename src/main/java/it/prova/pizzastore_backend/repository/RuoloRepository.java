package it.prova.pizzastore_backend.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long> {
	Ruolo findByDescrizione(String descrizione);
}
