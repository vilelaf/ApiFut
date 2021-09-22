package com.apifut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apifut.entities.Time;
import com.apifut.repositories.TimeRepository;

@Service
public class TimeService {

	@Autowired 
	TimeRepository repository;
	
	public Time save(Time time) {
		return repository.save(time);
	}
	
	public Optional<Time> findById(Long id) {
		Optional <Time> time = repository.findById(id);
		return time;
	}
	public Optional <Time> findByNome(String nome){
		return repository.findByNomeEquals(nome);
	}
	
	public Optional <Time> findByNomeEqualsIgnoreCase(String nome){

		return repository.findByNomeEqualsIgnoreCase(nome);
	}
	
	public List<Time> findAll() {
		return repository.findAll() ;
	}
	
	
}
