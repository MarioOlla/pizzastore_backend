package it.prova.pizzastore_backend.service.ordine;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.pizzastore_backend.model.Ordine;
import it.prova.pizzastore_backend.repository.ordine.OrdineRepository;

@Service
@Transactional
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository ordineRepository;
	
	@Override
	public List<Ordine> listAll() {
		return (List<Ordine>) ordineRepository.findAll();
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) {
		return ordineRepository.findById(id).orElse(null);
	}

	@Override
	public Ordine aggiorna(Long id, Ordine ordineInstance) {
		return ordineRepository.save(ordineInstance);
	}

	@Override
	public Ordine inserisciNuovo(Ordine ordineInstance) {
		return ordineRepository.save(ordineInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		ordineRepository.deleteById(idToRemove);
	}

	@Override
	public Ordine cercaPerCodice(String codice) {
		return ordineRepository.findByCodice(codice);
	}

}
