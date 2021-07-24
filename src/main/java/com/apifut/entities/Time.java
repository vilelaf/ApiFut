package com.apifut.entities;

import java.io.Serializable;

public class Time implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String formacao;
	
	
	public Time(Long id, String nome, String formacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.formacao = formacao;
	}
	
	public Time() {
		
	}
	
	
	
}
