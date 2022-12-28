package it.prova.pizzastore_backend.repository.ingrediente;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	Ingrediente findByDescrizione(String descrizione);
}
