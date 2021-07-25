package com.apifut.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

// Resolver como vai ser a situação da lista de times

@Entity
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String formacao;
	@JoinColumn(name = "jogadores")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Jogador> convocados;

	

	public Time(Long id, String nome, String formacao, List<Jogador> convocados) {

		this.id = id;
		this.nome = nome;
		this.formacao = formacao;
		this.convocados = convocados;
	}

	public Time() {
		
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

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
}
