package it.prova.pizzastore_backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "dataDiNascita")
	private LocalDate dataDiNascita;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@ManyToMany
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "ID"))
	private List<Ruolo> ruoli = new ArrayList<Ruolo>();
	@Enumerated(EnumType.STRING)
	private StatoUtente stato = StatoUtente.CREATO;

	public Utente() {

	}

	public Utente(Long id, String nome, String cognome, LocalDate dataDiNascita, String username, String password) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.username = username;
		this.password = password;
	}

	public Utente(Long id, String nome, String cognome, LocalDate dataDiNascita, String username, String password,
			List<Ruolo> ruoli, StatoUtente stato) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.username = username;
		this.password = password;
		this.ruoli = ruoli;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public StatoUtente getStato() {
		return stato;
	}

	public void setStato(StatoUtente stato) {
		this.stato = stato;
	}

	public class UtenteBuilder {

		private Utente utente;

		public UtenteBuilder() {
			this.utente = new Utente();
		}

		public UtenteBuilder id(Long id) {
			this.utente.id = id;
			return this;
		}

		public UtenteBuilder nome(String nome) {
			this.utente.nome = nome;
			return this;
		}

		public UtenteBuilder cognome(String cognome) {
			this.utente.cognome = cognome;
			return this;
		}

		public UtenteBuilder dataDiNascita(LocalDate dataDiNascita) {
			this.utente.dataDiNascita = dataDiNascita;
			return this;
		}

		public UtenteBuilder username(String username) {
			this.utente.username = username;
			return this;
		}

		public UtenteBuilder password(String password) {
			this.utente.password = password;
			return this;
		}

		public UtenteBuilder ruoli(List<Ruolo> ruoli) {
			this.utente.ruoli = ruoli;
			return this;
		}

		public UtenteBuilder stato(StatoUtente stato) {
			this.utente.stato = stato;
			return this;
		}

		public Utente build() {
			return this.utente;
		}

	}
}
