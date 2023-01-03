package it.prova.pizzastore_backend.service.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.pizzastore_backend.exception.ElementNotFoundException;
import it.prova.pizzastore_backend.exception.IdNotNullForInsertException;
import it.prova.pizzastore_backend.exception.IdNullBeforeEditException;
import it.prova.pizzastore_backend.model.Cliente;
import it.prova.pizzastore_backend.repository.cliente.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listAll() {
		return (List<Cliente>) repository.findAll();
	}

	@Override
	public Cliente caricaSingoloElemento(Long id) {
		Cliente c = repository.findById(id).orElse(null);
		if (c == null)
			throw new ElementNotFoundException("Couldn't find Cliente with id:" + id);
		return c;
	}

	@Override
	public Cliente aggiorna(Long id, Cliente clienteInstance) {
		if (clienteInstance.getId() == null)
			throw new IdNullBeforeEditException("This Cliente does not have a valorized id");
		Cliente c = repository.findById(id).orElse(null);
		if (c == null)
			throw new ElementNotFoundException("Couldn't find Cliente with id:" + id);
		return repository.save(clienteInstance);
	}

	@Override
	public Cliente inserisciNuovo(Cliente clienteInstance) {
		if (clienteInstance.getId() != null)
			throw new IdNotNullForInsertException("Expected no id, got id:" + clienteInstance.getId() + " instead");
		return repository.save(clienteInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		Cliente clienteToDisable = repository.findById(idToRemove).orElse(null);
		if (clienteToDisable == null)
			throw new ElementNotFoundException("couldn't find Cliente with id:" + idToRemove);
		else {
			clienteToDisable.setAttivo(false);
			repository.save(clienteToDisable);
		}
	}

	@Override
	public Cliente cercaPerIndirizzo(String indirizzo) {
		return repository.findByIndirizzo(indirizzo);
	}

}
