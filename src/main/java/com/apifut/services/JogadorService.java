package com.apifut.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.apifut.entities.Jogador;
import com.apifut.repositories.JogadorRepository;
import com.apifut.services.exceptions.DatabaseException;
import com.apifut.services.exceptions.ResourceNotFoundException;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repository;
	
	public List<Jogador> findAll(){
		
		return repository.findAll();
	} 
	
	public Jogador findById(Long id){
		Optional <Jogador> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Jogador save(Jogador j) {
		return repository.save(j);
	}
	
	public Jogador update(Long id, Jogador i) {
		try {
			Jogador j = repository.getById(id);
			updateData(j,i);
			return repository.save(j);
		} catch (EntityNotFoundException e) {
			 throw new ResourceNotFoundException(id);
		}
		
	}
	
	public Jogador updateData(Jogador j1, Jogador j2) {
		j1.setNome(j2.getNome());
		j1.setNumero(j2.getNumero());
		j1.setPosicao(j2.getPosicao());
		j1.setTime(j2.getTime());
		return j1;
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
}
