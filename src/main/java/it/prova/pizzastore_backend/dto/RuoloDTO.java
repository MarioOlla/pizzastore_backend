package it.prova.pizzastore_backend.dto;

import java.util.List;
import java.util.stream.Collectors;

import it.prova.pizzastore_backend.model.Ruolo;

public class RuoloDTO {
	
	private Long id;
	private String codice;
	private String descrizione;
	
	public RuoloDTO() {
		
	}

	public RuoloDTO(Long id, String codice, String descrizione) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Ruolo buildModelFromDTO() {
		Ruolo model = new Ruolo();
		if(this.id != null)
			model.setId(this.id);
		if(!this.codice.isBlank())
			model.setCodice(this.codice);
		if(!this.descrizione.isBlank())
			model.setDescrizione(this.descrizione);
		return model;
	}
	
	public static RuoloDTO buildDTOFromModel(Ruolo model) {
		RuoloDTO dto = new RuoloDTO();
		if(model.getId() != null)
			dto.setId(model.getId());
		if(!model.getCodice().isBlank())
			dto.setCodice(model.getCodice());
		if(!model.getDescrizione().isBlank())
			dto.setDescrizione(model.getDescrizione());
		return dto;
	}
	
	public static List<Ruolo> buildModelListFromDTOList(List<RuoloDTO> dtos) {
		return dtos.stream()
				.map(r -> r.buildModelFromDTO())
				.collect(Collectors.toList());
	}
	
	public static List<RuoloDTO> buildDTOListFromModelList(List<Ruolo> models) {
		return models.stream()
				.map(r -> RuoloDTO.buildDTOFromModel(r))
				.collect(Collectors.toList());
	}
}
