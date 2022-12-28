package it.prova.pizzastore_backend.service.cliente;

import java.util.List;

import it.prova.pizzastore_backend.model.Cliente;

public interface ClienteService {
	public List<Cliente> listAll();

	public Cliente caricaSingoloElemento(Long id);

	public Cliente aggiorna(Long id ,Cliente clienteInstance);

	public Cliente inserisciNuovo(Cliente clienteInstance);

	public void rimuovi(Long idToRemove);

	public Cliente cercaPerIndirizzo(String indirizzo);
}
