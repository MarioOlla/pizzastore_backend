package it.prova.pizzastore_backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.pizzastore_backend.model.Pizza;

public class PizzaDTO {
	private Long id;
	@NotBlank(message = "{pizza.descrizione.notblank}")
	private String descrizione;
	@NotNull(message = "{pizza.prezzo.notnull}")
	@Min(value = 5,message = "pizza.prezzo.belowMinValue")
	private Float prezzo;
	private Boolean attivo;
	private List<IngredienteDTO> ingredienti = new ArrayList<>();
	
	public PizzaDTO() {

	}

	public PizzaDTO(Long id, String descrizione, Float prezzo, Boolean attivo, List<IngredienteDTO> ingredienti) {
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

	public List<IngredienteDTO> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<IngredienteDTO> ingredienti) {
		this.ingredienti = ingredienti;
	}
	
	public Pizza buildModelFromDTO() {
		Pizza model = new Pizza();
		if(this.id != null)
			model.setId(id);
		if(!this.descrizione.isBlank())
			model.setDescrizione(descrizione);
		if(this.prezzo != null)
			model.setPrezzo(prezzo);
		if(this.attivo != null)
			model.setAttivo(attivo);
		if(this.ingredienti.size() > 0)
			model.setIngredienti(IngredienteDTO.buildModelListFromDTOList(ingredienti));
		return model;
	}
	
	public static PizzaDTO buildDTOFromModel(Pizza model) {
		PizzaDTO dto = new PizzaDTO();
		if(model.getId() != null)
			dto.setId(model.getId());
		if(!model.getDescrizione().isBlank())
			dto.setDescrizione(model.getDescrizione());
		if(model.getPrezzo() != null)
			dto.setPrezzo(model.getPrezzo());
		if(model.getAttivo() != null)
			dto.setAttivo(model.getAttivo());
		if(model.getIngredienti().size() > 0)
			dto.setIngredienti(IngredienteDTO.buildDTOListFromModelList(model.getIngredienti()));
		return dto;
	}
	
	public static List<Pizza> buildModelListFromDTOList(List<PizzaDTO> dtos) {
		return dtos.stream()
				.map(r -> r.buildModelFromDTO())
				.collect(Collectors.toList());
	}
	
	public static List<PizzaDTO> buildDTOListFromModelList(List<Pizza> models) {
		return models.stream()
				.map(r -> PizzaDTO.buildDTOFromModel(r))
				.collect(Collectors.toList());
	}
}
