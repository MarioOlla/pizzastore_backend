package it.prova.pizzastore_backend.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.pizzastore_backend.model.Ordine;

public class OrdineDTO {
	
	private Long id;
	@NotNull(message = "{ordine.data.notnull}")
	private LocalDate data;
	private Boolean closed = false;
	@NotBlank(message = "{ordine.codice.notblank}")
	private String codice;
	@NotNull(message = "{ordine.fattorino.notnull}")
	private UtenteDTO fattorino;
	private Float costoTotale;
	private List<PizzaDTO> pizze = new ArrayList<>();
	@NotNull(message = "{ordine.cliente.notnull}")
	private ClienteDTO cliente;
	
	public OrdineDTO() {

	}

	public OrdineDTO(Long id, LocalDate data, Boolean closed, String codice, UtenteDTO fattorino, Float costoTotale,
			List<PizzaDTO> pizze, ClienteDTO cliente) {
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

	public UtenteDTO getFattorino() {
		return fattorino;
	}

	public void setFattorino(UtenteDTO fattorino) {
		this.fattorino = fattorino;
	}

	public Float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(Float costoTotale) {
		this.costoTotale = costoTotale;
	}

	public List<PizzaDTO> getPizze() {
		return pizze;
	}

	public void setPizze(List<PizzaDTO> pizze) {
		this.pizze = pizze;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public Ordine buildModelFromDTO() {
		Ordine model = new Ordine();
		if(this.id != null)
			model.setId(id);
		if(this.data != null)
			model.setData(data);
		if(this.closed != null)
			model.setClosed(closed);
		if(!this.codice.isBlank())
			model.setCodice(codice);
		if(this.costoTotale != null)
			model.setCostoTotale(costoTotale);
		if(this.fattorino != null)
			model.setFattorino(fattorino.buildModel());
		if(this.cliente != null)
			model.setCliente(cliente.buildModelFromDTO());
		if(this.pizze.size() > 0)
			model.setPizze(PizzaDTO.buildModelListFromDTOList(pizze));
		return model;
	}
	
	public static OrdineDTO buildDTOFromModel(Ordine model) {
		OrdineDTO dto = new OrdineDTO();
		if(model.getId() != null)
			dto.setId(model.getId());
		if(model.getData() != null)
			dto.setData(model.getData());
		if(model.getClosed() != null)
			dto.setClosed(model.getClosed());
		if(!model.getCodice().isBlank())
			dto.setCodice(model.getCodice());
		if(model.getCostoTotale() != null)
			dto.setCostoTotale(model.getCostoTotale());
		if(model.getFattorino() != null)
			dto.setFattorino(UtenteDTO.buildRisorsaDTOFromModel(model.getFattorino(), false, false, false));
		if(model.getCliente() != null)
			dto.setCliente(ClienteDTO.buildDTOFromModel(model.getCliente()));
		if(model.getPizze().size() > 0)
			dto.setPizze(PizzaDTO.buildDTOListFromModelList(model.getPizze()));
		return dto;
	}
	
	public static List<Ordine> buildModelListFromDTOList(List<OrdineDTO> dtos) {
		return dtos.stream()
				.map(r -> r.buildModelFromDTO())
				.collect(Collectors.toList());
	}
	
	public static List<OrdineDTO> buildDTOListFromModelList(List<Ordine> models) {
		return models.stream()
				.map(r -> OrdineDTO.buildDTOFromModel(r))
				.collect(Collectors.toList());
	}
}