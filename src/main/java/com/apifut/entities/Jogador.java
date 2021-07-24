package com.apifut.entities;

import java.io.Serializable;

import com.apifut.util.enums.PosicaoEnum;

public class Jogador implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private PosicaoEnum posicao;
	private Time time;
	private Integer numero;
	
	public Jogador() {
	
	}
	
	public Jogador(Long id, String nome, PosicaoEnum posicao, Time time, Integer numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.posicao = posicao;
		this.time = time;
		this.numero = numero;
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
	public PosicaoEnum getPosicao() {
		return posicao;
	}
	public void setPosicao(PosicaoEnum posicao) {
		this.posicao = posicao;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
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
