package it.prova.pizzastore_backend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StatsOutput {
	
	private LocalDate dataDa;
	private LocalDate dataA;
	private Float ricaviTotali;
	private Float costiTotali;
	private Long numeroOrdini;
	private Long numeroPizze;
	private List<ClienteDTO> clientiVirtuosi = new ArrayList<>();
	
	public StatsOutput() {

	}

	public StatsOutput(LocalDate dataDa, LocalDate dataA, Float ricaviTotali, Float costiTotali, Long numeroOrdini,
			Long numeroPizze, List<ClienteDTO> clientiVirtuosi) {
		this.dataDa = dataDa;
		this.dataA = dataA;
		this.ricaviTotali = ricaviTotali;
		this.costiTotali = costiTotali;
		this.numeroOrdini = numeroOrdini;
		this.numeroPizze = numeroPizze;
		this.clientiVirtuosi = clientiVirtuosi;
	}

	public LocalDate getDataDa() {
		return dataDa;
	}

	public void setDataDa(LocalDate dataDa) {
		this.dataDa = dataDa;
	}

	public LocalDate getDataA() {
		return dataA;
	}

	public void setDataA(LocalDate dataA) {
		this.dataA = dataA;
	}

	public Float getRicaviTotali() {
		return ricaviTotali;
	}

	public void setRicaviTotali(Float ricaviTotali) {
		this.ricaviTotali = ricaviTotali;
	}

	public Float getCostiTotali() {
		return costiTotali;
	}

	public void setCostiTotali(Float costiTotali) {
		this.costiTotali = costiTotali;
	}

	public Long getNumeroOrdini() {
		return numeroOrdini;
	}

	public void setNumeroOrdini(Long numeroOrdini) {
		this.numeroOrdini = numeroOrdini;
	}

	public Long getNumeroPizze() {
		return numeroPizze;
	}

	public void setNumeroPizze(Long numeroPizze) {
		this.numeroPizze = numeroPizze;
	}

	public List<ClienteDTO> getClientiVirtuosi() {
		return clientiVirtuosi;
	}

	public void setClientiVirtuosi(List<ClienteDTO> clientiVirtuosi) {
		this.clientiVirtuosi = clientiVirtuosi;
	}

}
