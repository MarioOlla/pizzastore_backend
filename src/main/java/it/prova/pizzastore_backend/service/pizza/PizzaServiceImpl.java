package it.prova.pizzastore_backend.service.pizza;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.pizzastore_backend.model.Ingrediente;
import it.prova.pizzastore_backend.model.Pizza;
import it.prova.pizzastore_backend.repository.pizza.PizzaRepository;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	@Override
	public List<Pizza> listAll() {
		return (List<Pizza>) pizzaRepository.findAll();
	}

	@Override
	public Pizza caricaSingoloElemento(Long id) {
		return pizzaRepository.findById(id).orElse(null);
	}

	@Override
	public Pizza aggiorna(Long id, Pizza pizzaInstance) {
		return pizzaRepository.save(pizzaInstance);
	}

	@Override
	public Pizza inserisciNuovo(Pizza pizzaInstance) {
		return pizzaRepository.save(pizzaInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		pizzaRepository.deleteById(idToRemove);
	}

	@Override
	public Pizza cercaPerDescrizione(String descrizione) {
		return pizzaRepository.findByDescrizione(descrizione);
	}
	
	@Override
	public Float calcolaPrezzoPizza(Pizza pizza) {
		float res = Pizza.getPrezzoBase();
		for (Ingrediente ingredienteItem: pizza.getIngredienti()) {
			res += ingredienteItem.getPrezzo();
		}
		return res;
	}
}
