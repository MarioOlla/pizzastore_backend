package it.prova.pizzastore_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, CustomUtenteRepository {
	
	@EntityGraph(attributePaths = { "ruoli" })
	Optional<Utente> findByUsername(String username);
	
	@Query("from Utente u left join fetch u.ruoli where u.id = ?1")
	Optional<Utente> findByIdConRuolo(Long id);
	
	@EntityGraph(attributePaths = { "ruoli" })
	Utente findByUsernameAndPassword(String username,String password);

}
