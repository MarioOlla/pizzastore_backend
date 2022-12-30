package it.prova.pizzastore_backend.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.pizzastore_backend.model.Ingrediente;

public class IngredienteDTO {
	private Long id;
	@NotBlank(message = "{ingrediente.codice.notblank}")
	private String codice;
	@NotBlank(message = "{ingrediente.descrizione.notblank}")
	private String descrizione;
	@NotNull(message = "{ingrediente.prezzo.notnull}")
	@Min(value = 0, message = "ingrediente.prezzo.notNegative")
	private Float prezzo;

	public IngredienteDTO() {

	}

	public IngredienteDTO(Long id, String codice, String descrizione, Float prezzo) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
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

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Ingrediente buildModelFromDTO() {
		Ingrediente model = new Ingrediente();
		if (this.id != null)
			model.setId(this.id);
		if (!this.codice.isBlank())
			model.setCodice(this.codice);
		if (!this.descrizione.isBlank())
			model.setDescrizione(this.descrizione);
		if (this.prezzo != null)
			model.setPrezzo(this.prezzo);
		return model;
	}

	public static IngredienteDTO buildDTOFromModel(Ingrediente model) {
		IngredienteDTO dto = new IngredienteDTO();
		if (model.getId() != null)
			dto.setId(model.getId());
		if (!model.getCodice().isBlank())
			dto.setCodice(model.getCodice());
		if (!model.getDescrizione().isBlank())
			dto.setDescrizione(model.getDescrizione());
		if (model.getPrezzo() != null)
			dto.setPrezzo(model.getPrezzo());
		return dto;
	}

	public static List<Ingrediente> buildModelListFromDTOList(List<IngredienteDTO> dtos) {
		return dtos.stream().map(r -> r.buildModelFromDTO()).collect(Collectors.toList());
	}

	public static List<IngredienteDTO> buildDTOListFromModelList(List<Ingrediente> models) {
		return models.stream().map(r -> IngredienteDTO.buildDTOFromModel(r)).collect(Collectors.toList());
	}
}
