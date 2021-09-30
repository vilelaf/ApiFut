package com.apifut.DTO;

import com.apifut.entities.Time;
import com.apifut.util.enums.PosicaoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JogadorDTO {

	private Long id;
	@Length (min=3, max = 100, message= "O nome deve conter entre 3 e 100 caracteres")
	private String nome;
	@NotNull(message = "Em alguma posição o colega tem que jogar, defina a posição.")
	@Pattern(regexp = "^(GOL|ZAG|MEI|ATA)$", message = "Para o tipo somente são aceitos os valores de GOL,ZAG,MEI ou ATA ") 
	private String posicao;
	private BigDecimal idade;
	private String Nacionalidade;
	
	private Time time;
	private Integer numero;

}
