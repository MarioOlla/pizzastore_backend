package it.prova.pizzastore_backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "data")
	private LocalDate data;
	@Column(name = "closed")
	private Boolean closed;
	@Column(name = "codice")
	private String codice;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fattorino_id", nullable = false)
	private Utente fattorino;
	@Column(name = "costoTotale")
	private Float costoTotale;
	@ManyToMany
	@JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
	private List<Pizza> pizze = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public Ordine() {

	}

	public Ordine(Long id, LocalDate data, Boolean closed, String codice, Utente fattorino, Float costoTotale,
			List<Pizza> pizze, Cliente cliente) {
		this.id = id;
		this.data = data;
		this.closed = closed;
		this.codice = codice;
		this.fattorino = fattorino;
		this.costoTotale = costoTotale;
		this.pizze = pizze;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Utente getFattorino() {
		return fattorino;
	}

	public void setFattorino(Utente fattorino) {
		this.fattorino = fattorino;
	}

	public Float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(Float costoTotale) {
		this.costoTotale = costoTotale;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
