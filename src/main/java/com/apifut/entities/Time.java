package com.apifut.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "times") 
public class Time implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String formacao;

	@OneToMany(mappedBy = "time")
	private Set<Jogador> jogadores = new HashSet();

	public Time(Long id, String nome, String formacao) {

		this.id = id;
		this.nome = nome;
		this.formacao = formacao;
		
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

	
	public Set<Jogador> getJogadores() {
		Set <Jogador> set = new HashSet();
		for (Jogador j : jogadores) {
			set.add(j);
		}
		return set;
	}

}
