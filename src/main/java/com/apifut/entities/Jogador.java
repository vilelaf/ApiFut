package com.apifut.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.apifut.util.enums.PosicaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name = "jogadores")
public class Jogador implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nome;
	@Enumerated(EnumType.STRING)
	private PosicaoEnum posicao;
	
	private BigDecimal idade;
	private String nacionalidade;
	private Integer numero;

	@ManyToOne
	@JoinColumn(name="time_id")
	private Time time;
	
	public Jogador() {
	
	}
	
	public Jogador(Long id, String nome, PosicaoEnum posicao, BigDecimal idade, 
			String nacionalidade, Integer numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.posicao = posicao;
		this.numero = numero;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
	}
	
	


	@JsonIgnore
	public Time getTime() {
		return time;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
