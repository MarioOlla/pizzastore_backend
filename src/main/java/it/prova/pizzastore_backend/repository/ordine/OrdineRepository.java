package it.prova.pizzastore_backend.repository.ordine;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastore_backend.model.Cliente;
import it.prova.pizzastore_backend.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long>,CustomOrdineRepository{
	Ordine findByCodice(String codice);
	
	@Query("select sum(o.costoTotale) from Ordine o where o.data between :dataDa and :dataA")
	public Float incassiTotaliDaA(LocalDate dataDa, LocalDate dataA);
	
	@Query("select count(o) from Ordine o where o.data between :dataDa and :dataA")
	public Long numeroOrdiniDaA(LocalDate dataDa, LocalDate dataA);
	
	@Query("select count(p) from Ordine o left join o.pizze p where o.data between :dataDa and :dataA")
	public Long numeroPizzeDaA(LocalDate dataDa, LocalDate dataA);
	
	@Query("select c from Ordine o left join o.cliente c where o.costoTotale > 100 and o.data between :dataDa and :dataA")
	public List<Cliente> clientiVirtuosiDaA(LocalDate dataDa, LocalDate dataA);
	
	@Query("select o from Ordine o inner join o.fattorino f where f.username=:name and o.closed = FALSE")
	List<Ordine> findByFattorino(String name);
	
}
