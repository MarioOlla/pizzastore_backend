package it.prova.pizzastore_backend;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.pizzastore_backend.model.Ruolo;
import it.prova.pizzastore_backend.model.StatoUtente;
import it.prova.pizzastore_backend.model.Utente;
import it.prova.pizzastore_backend.service.RuoloService;
import it.prova.pizzastore_backend.service.UtenteService;

@SpringBootApplication
public class PizzastoreBackendApplication implements CommandLineRunner {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private RuoloService ruoloService;

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (ruoloService.cercaPerDescrizione("Amministratore") == null)
			ruoloService.inserisciNuovo(new Ruolo(null, "Amministratore", Ruolo.ADMIN_ROLE));
		if (ruoloService.cercaPerDescrizione("Proprietario") == null)
			ruoloService.inserisciNuovo(new Ruolo(null, "Proprietario", Ruolo.PROPRIETARIO_ROLE));
		if (ruoloService.cercaPerDescrizione("Pizzaiolo") == null)
			ruoloService.inserisciNuovo(new Ruolo(null, "Pizzaiolo", Ruolo.PIZZAIOLO_ROLE));
		if (ruoloService.cercaPerDescrizione("Fattorino") == null)
			ruoloService.inserisciNuovo(new Ruolo(null, "Fattorino", Ruolo.FATTORINO_ROLE));

		List<Ruolo> admin = Collections.singletonList(ruoloService.cercaPerDescrizione("Amministratore"));
		List<Ruolo> owner = Collections.singletonList(ruoloService.cercaPerDescrizione("Proprietario"));
		List<Ruolo> pizz = Collections.singletonList(ruoloService.cercaPerDescrizione("Pizzaiolo"));
		List<Ruolo> fatt = Collections.singletonList(ruoloService.cercaPerDescrizione("Fattorino"));

		if (utenteService.findByUsername("admin") == null)
			utenteService.inserisciNuovo(new Utente(null, "Luca", "Rossi", LocalDate.of(1991, 3, 12), "admin", "admin",
					admin, StatoUtente.ATTIVO));
		if (utenteService.findByUsername("owner") == null)
			utenteService.inserisciNuovo(new Utente(null, "Paolo", "Bianchi", LocalDate.of(1991, 3, 12), "owner", "owner",
					owner, StatoUtente.ATTIVO));
		if (utenteService.findByUsername("pizz") == null)
			utenteService.inserisciNuovo(new Utente(null, "Giorgio", "Verdi", LocalDate.of(1991, 3, 12), "pizz", "pizz",
					pizz, StatoUtente.ATTIVO));
		if (utenteService.findByUsername("fatt") == null)
			utenteService.inserisciNuovo(new Utente(null, "Mario", "Neri", LocalDate.of(1991, 3, 12), "fatt", "fatt",
					fatt, StatoUtente.ATTIVO));
	}

}
