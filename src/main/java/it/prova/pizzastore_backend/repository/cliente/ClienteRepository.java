package it.prova.pizzastore_backend.repository.cliente;

import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	Cliente findByIndirizzo (String indirizzo);
}
