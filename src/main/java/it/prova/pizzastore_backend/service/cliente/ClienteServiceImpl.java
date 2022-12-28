package it.prova.pizzastore_backend.service.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return repository.findById(id).orElse(null);
	}

	@Override
	public Cliente aggiorna(Long id, Cliente clienteInstance) {
		return repository.save(clienteInstance);
	}

	@Override
	public Cliente inserisciNuovo(Cliente clienteInstance) {
		return repository.save(clienteInstance);
	}

	@Override
	public void rimuovi(Long idToRemove) {
		repository.existsById(idToRemove);
	}

	@Override
	public Cliente cercaPerIndirizzo(String indirizzo) {
		return repository.findByIndirizzo(indirizzo);
	}

}
