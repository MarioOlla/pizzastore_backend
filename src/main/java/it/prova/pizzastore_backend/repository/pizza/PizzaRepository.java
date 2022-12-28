package it.prova.pizzastore_backend.repository.pizza;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
	Pizza findByDescrizione(String descrizione);
}
