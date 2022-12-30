package it.prova.pizzastore_backend.dto;

import java.time.LocalDate;

public class IntervalloDate {
	
	private LocalDate dataDa;
	private LocalDate dataA;
	
	public IntervalloDate() {

	}

	public IntervalloDate(LocalDate dataDa, LocalDate dataA) {
		this.dataDa = dataDa;
		this.dataA = dataA;
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
	
	
}
