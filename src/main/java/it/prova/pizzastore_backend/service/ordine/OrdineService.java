package it.prova.pizzastore_backend.service.ordine;

import java.time.LocalDate;
import java.util.List;

import it.prova.pizzastore_backend.dto.IntervalloDate;
import it.prova.pizzastore_backend.dto.StatsOutput;
import it.prova.pizzastore_backend.model.Cliente;
import it.prova.pizzastore_backend.model.Ordine;

public interface OrdineService {
	
	public List<Ordine> listAll();

	public Ordine caricaSingoloElemento(Long id);

	public Ordine aggiorna(Long id, Ordine ordineInstance);

	public Ordine inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Long idToRemove);

	public Ordine cercaPerCodice(String codice);
	
	public Float calcolaPrezzoOrdine(Ordine ordine);
	
	public Float incassiTotaliDaA(LocalDate dataDa, LocalDate dataA);
	
	public Long numeroOrdiniDaA(LocalDate dataDa, LocalDate dataA);
	
	public Long numeroPizzeDaA(LocalDate dataDa, LocalDate dataA);
	
	public List<Cliente> clientiVirtuosiDaA(LocalDate dataDa, LocalDate dataA);

	public StatsOutput getStats(IntervalloDate intervallo);
	
}
