package com.apifut.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apifut.entities.Jogador;
import com.apifut.entities.Time;
import com.apifut.repositories.TimeRepository;
import com.apifut.services.exceptions.ResourceNotFoundException;

@Service
public class TimeService {

	@Autowired 
	TimeRepository repository;
	
	public Time save(Time time) {
		return repository.save(time);
	}
	
	public List<Time> findAll() {
		return repository.findAll() ;
	}
	
	public Time findById(Long id) {
		Optional <Time> time = repository.findById(id);
		return time.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Optional <Time> findByNome(String nome){
		return repository.findByNomeEquals(nome);
	}
	
	public Optional <Time> findByNomeEqualsIgnoreCase(String nome){

		return repository.findByNomeEqualsIgnoreCase(nome);
	}
	

	public Time updateByName(String name, Time t1) {
		try {
			ConvertService c = new ConvertService();
			Optional<Time> time = repository.findByNomeEqualsIgnoreCase(name);
			Time t2 = c.convertTimeDTOtoEntity(c.convertTimeObjToTimeDTO(time));
			updateData(t2,t1);
			return repository.save(t2);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage() + t1.getId());
		}
	}
	
	
	public Time updateData(Time t1, Time t2) {
		t1.setNome(t2.getNome());
		t1.setId(t2.getId());
		t1.setFormacao(t2.getFormacao());
		t1.setTodosOsJogadores(t2.getJogadores());
		return t1;
	}
	

	
	
	
	
}
