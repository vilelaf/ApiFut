package com.apifut.DTO;

import com.apifut.entities.Time;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JogadorDTO {

	private Long id;
	private String nome;
	@NotNull(message =  "Defina a posição.")
	@Pattern(regexp = "^(GOL|ZAG|MEI|ATA)$", message = "Para o tipo somente são aceitos os valores de GOL,ZAG,MEI ou ATA ") 
	private String posicao;
	private BigDecimal idade;
	private String Nacionalidade;
	private Integer numero;
	
	private Time time;
	

}
