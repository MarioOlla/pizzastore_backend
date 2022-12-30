package it.prova.pizzastore_backend.repository.ordine;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>{
	Ordine findByCodice(String codice);
}
