package com.apifut.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.apifut.entities.Jogador;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeDTO {

	private Long id;
	@NotNull(message = "O nome não pode ser nulo.")
	private String nome;
	private String formacao;
	
	private Set<Jogador> jogadores = new HashSet();
	
	public void setJogadores(Set<Jogador> j ){
		this.jogadores = j;
	}
	
}
