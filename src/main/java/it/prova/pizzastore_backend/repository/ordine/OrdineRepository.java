package it.prova.pizzastore_backend.repository.ordine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>,CustomOrdineRepository{
	Ordine findByCodice(String codice);
	
	@Query("select o from Ordine o inner join o.fattorino f where f.username=:name and o.closed = FALSE")
	List<Ordine> findByFattorino(String name);
}
