package it.prova.pizzastore_backend.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.prova.pizzastore_backend.model.Utente;

public class UtenteDTO {
	
	private Long id;
	@NotBlank(message = "{utente.nome.notblank}")
	private String nome;
	@NotBlank(message = "{utente.cognome.notblank}")
	private String cognome;
	@NotBlank(message = "{utente.username.notblank}")
	@Size(min = 3, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	private String username;
	@NotNull(message = "{utente.dataDiNascita.notnull}")
	private LocalDate dataDiNascita;
	
	public UtenteDTO() {
		
	}

	public UtenteDTO(Long id, String nome, String cognome, String username, LocalDate dataDiNascita, String token) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.dataDiNascita = dataDiNascita;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}	

	public Utente buildModel() {
		Utente res = new Utente();
		res.setId(this.getId());
		res.setNome(this.getNome());
		res.setCognome(this.getCognome());
		res.setUsername(this.getUsername());
		res.setDataDiNascita(this.getDataDiNascita());
		return res;
	}

	public static UtenteDTO buildRisorsaDTOFromModel(Utente ele, boolean b, boolean c, boolean d) {
		UtenteDTO res = new UtenteDTO();
		res.setId(ele.getId());
		res.setNome(ele.getNome());
		res.setCognome(ele.getCognome());
		res.setUsername(ele.getUsername());
		res.setDataDiNascita(ele.getDataDiNascita());
		return res;
	}

	public static List<UtenteDTO> createRisorsaDTOListFromModelList(List<Utente> modelList, boolean b,
			boolean c, boolean d) {

		return modelList.stream()
				.map(e -> UtenteDTO.buildRisorsaDTOFromModel(e, b, c, d))
				.collect(Collectors.toList());
	}
	
	public static List<Utente> createModelListFromDtos(List<UtenteDTO> dtos){
		return dtos.stream()
				.map(dto -> dto.buildModel())
				.collect(Collectors.toList());
	}

}
