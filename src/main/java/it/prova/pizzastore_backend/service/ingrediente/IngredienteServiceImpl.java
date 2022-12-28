package it.prova.pizzastore_backend.service.ingrediente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore_backend.model.Ingrediente;
import it.prova.pizzastore_backend.repository.ingrediente.IngredienteRepository;

public class IngredienteServiceImpl implements IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public List<Ingrediente> listAll() {
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente caricaSingoloElemento(Long id) {
		return ingredienteRepository.findById(id).orElse(null);
	}

	@Override
	public Ingrediente aggiorna(Ingrediente ingredienteInstance) {
		return ingredienteRepository.save(ingredienteInstance);
	}

	@Override
	public Ingrediente inserisciNuovo(Ingrediente ingredienteInstance) {
		return ingredienteRepository.save(ingredienteInstance);		
	}

	@Override
	public void rimuovi(Long idToRemove) {
		ingredienteRepository.deleteById(idToRemove);;		
	}

	@Override
	public Ingrediente cercaPerDescrizione(String descrizione) {
		ingredienteRepository.findByDescrizione(descrizione);
		return null;
	}

}
