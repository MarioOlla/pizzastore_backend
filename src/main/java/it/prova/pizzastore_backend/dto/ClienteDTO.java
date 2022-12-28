package it.prova.pizzastore_backend.dto;

import java.util.List;
import java.util.stream.Collectors;

import it.prova.pizzastore_backend.model.Cliente;

public class ClienteDTO {
	
	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private Boolean attivo;
	
public ClienteDTO() {
		
	}

	public ClienteDTO(Long id, String nome, String cognome, String indirizzo, Boolean attivo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.attivo = attivo;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}
	
	public Cliente buildModelFromDTO() {
		Cliente model = new Cliente();
		if(this.id != null)
			model.setId(id);
		if(!this.nome.isBlank())
			model.setNome(nome);
		if(!this.cognome.isBlank())
			model.setCognome(cognome);
		if(!this.indirizzo.isBlank())
			model.setIndirizzo(indirizzo);
		if(this.attivo != null)
			model.setAttivo(attivo);
		return model;
	}
	
	public static ClienteDTO buildDTOFromModel(Cliente model) {
		ClienteDTO dto = new ClienteDTO();
		if(model.getId() != null)
			dto.setId(model.getId());
		if(!model.getNome().isBlank())
			dto.setNome(model.getNome());
		if(!model.getCognome().isBlank())
			dto.setCognome(model.getCognome());
		if(!model.getIndirizzo().isBlank())
			dto.setIndirizzo(model.getIndirizzo());
		if(model.getAttivo() != null)
			dto.setAttivo(model.getAttivo());
		return dto;
	}
	
	public static List<Cliente> buildModelListFromDTOList(List<ClienteDTO> dtos) {
		return dtos.stream()
				.map(r -> r.buildModelFromDTO())
				.collect(Collectors.toList());
	}
	
	public static List<ClienteDTO> buildDTOListFromModelList(List<Cliente> models) {
		return models.stream()
				.map(r -> ClienteDTO.buildDTOFromModel(r))
				.collect(Collectors.toList());
	}
}
