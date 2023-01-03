package it.prova.pizzastore_backend.service.ordine;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.pizzastore_backend.dto.ClienteDTO;
import it.prova.pizzastore_backend.dto.IntervalloDate;
import it.prova.pizzastore_backend.dto.StatsOutput;
import it.prova.pizzastore_backend.exception.ElementNotFoundException;
import it.prova.pizzastore_backend.model.Cliente;
import it.prova.pizzastore_backend.model.Ordine;
import it.prova.pizzastore_backend.model.Pizza;
import it.prova.pizzastore_backend.repository.ordine.OrdineRepository;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository ordineRepository;
	
	@Override
	@Transactional
	public List<Ordine> listAll() {
		return (List<Ordine>) ordineRepository.findAll();
	}

	@Override
	@Transactional
	public Ordine caricaSingoloElemento(Long id) {
		return ordineRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Ordine aggiorna(Long id, Ordine ordineInstance) {
		return ordineRepository.save(ordineInstance);
	}

	@Override
	@Transactional
	public Ordine inserisciNuovo(Ordine ordineInstance) {
		return ordineRepository.save(ordineInstance);
	}

	@Override
	@Transactional
	public void rimuovi(Long idToRemove) {
		ordineRepository.deleteById(idToRemove);
	}

	@Override
	@Transactional
	public Ordine cercaPerCodice(String codice) {
		return ordineRepository.findByCodice(codice);
	}

	@Override
	public Float calcolaPrezzoOrdine(Ordine ordine) {
		float res = 0f;
		for (Pizza pizzaItem: ordine.getPizze()) {
			res += pizzaItem.getPrezzo();
		}
		return res;
	}

	@Override
	@Transactional
	public Float incassiTotaliDaA(LocalDate dataDa, LocalDate dataA) {
		Float res = ordineRepository.incassiTotaliDaA(dataDa, dataA);
		return res!=null?res:0f;
	}

	@Override
	@Transactional
	public Long numeroOrdiniDaA(LocalDate dataDa, LocalDate dataA) {
		Long res = ordineRepository.numeroOrdiniDaA(dataDa, dataA);
		return res!=null?res:0;
	}

	@Override
	@Transactional
	public Long numeroPizzeDaA(LocalDate dataDa, LocalDate dataA) {
		Long res = ordineRepository.numeroPizzeDaA(dataDa, dataA);
		return res!=null?res:0;
	}

	@Override
	@Transactional
	public List<Cliente> clientiVirtuosiDaA(LocalDate dataDa, LocalDate dataA) {
		return ordineRepository.clientiVirtuosiDaA(dataDa, dataA);
	}

	@Override
	@Transactional
	public StatsOutput getStats(IntervalloDate intervallo) {
		StatsOutput stats = new StatsOutput();
		stats.setDataDa(intervallo.getDataDa());
		stats.setDataA(intervallo.getDataA());
		stats.setRicaviTotali(this.incassiTotaliDaA(intervallo.getDataDa(), intervallo.getDataA()));
		stats.setNumeroOrdini(this.numeroOrdiniDaA(intervallo.getDataDa(), intervallo.getDataA()));
		stats.setNumeroPizze(this.numeroPizzeDaA(intervallo.getDataDa(), intervallo.getDataA()));
		stats.setCostiTotali(Pizza.getPrezzoBase()*stats.getNumeroPizze());
		stats.setClientiVirtuosi(ClienteDTO.buildDTOListFromModelList( this.clientiVirtuosiDaA(intervallo.getDataDa(), intervallo.getDataA())));
		return stats;		
	}

	@Override
	@Transactional
	public List<Ordine> listaOrdiniDi(String name) {
		return ordineRepository.findByFattorino(name);
	}

	@Override
	@Transactional
	public Ordine chiudiOrdine(Long id) {
		Ordine ordineReloaded = ordineRepository.findById(id).orElse(null);
		if(ordineReloaded == null)
			throw new ElementNotFoundException("couldn't find ordine with id:"+id);
		else {
			ordineReloaded.setClosed(true);
			ordineRepository.save(ordineReloaded);
		}
		return ordineReloaded;
	}

	@Override
	@Transactional
	public List<Ordine> findByExample(Ordine example) {
		return ordineRepository.findByExample(example);
	}

}
