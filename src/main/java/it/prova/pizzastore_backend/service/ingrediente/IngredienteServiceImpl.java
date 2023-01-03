package it.prova.pizzastore_backend.service.ingrediente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.pizzastore_backend.exception.ElementNotFoundException;
import it.prova.pizzastore_backend.exception.IdNotNullForInsertException;
import it.prova.pizzastore_backend.exception.IdNullBeforeEditException;
import it.prova.pizzastore_backend.model.Ingrediente;
import it.prova.pizzastore_backend.repository.ingrediente.IngredienteRepository;

@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService {
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public List<Ingrediente> listAll() {
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}

	@Override
	public Ingrediente caricaSingoloElemento(Long id) {
		Ingrediente ing = ingredienteRepository.findById(id).orElse(null);
		if(ing == null)
			throw new ElementNotFoundException("Couldn't find Ingrediente with id:"+id);
		return ing;
	}

	@Override
	public Ingrediente aggiorna(Long id, Ingrediente ingredienteInstance) {
		if(ingredienteInstance.getId() == 0)
			throw new IdNullBeforeEditException("This ingrediente does not have a valorized id");
		Ingrediente ing = ingredienteRepository.findById(id).orElse(null);
		if(ing == null)
			throw new ElementNotFoundException("Couldn't find Ingrediente with id:"+id);
		return ingredienteRepository.save(ingredienteInstance);
	}

	@Override
	public Ingrediente inserisciNuovo(Ingrediente ingredienteInstance) {
		if(ingredienteInstance.getId() != null)
			throw new IdNotNullForInsertException("Expected no id, got id:"+ingredienteInstance.getId()+" instead");
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
