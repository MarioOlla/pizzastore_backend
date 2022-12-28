package it.prova.pizzastore_backend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	public static final Float PREZZO_BASE = 5.50f;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private Float prezzo;
	@Column(name = "attivo")
	private Boolean attivo = true;
	@ManyToMany
	@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ingrediene_id", referencedColumnName = "ID"))
	private List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();

	public Pizza() {

	}

	public Pizza(Long id, String descrizione, Float prezzo, Boolean attivo, List<Ingrediente> ingredienti) {
		this.id = id;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.attivo = attivo;
		this.ingredienti = ingredienti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

}
