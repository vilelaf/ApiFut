package com.apifut.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apifut.entities.Time;
import com.apifut.services.TimeService;

@RestController
@RequestMapping (value = "/times")
public class TimeResource {

	@Autowired
	private TimeService service;
	
	@GetMapping
	public ResponseEntity <List<Time>> findAll(){
		List<Time> todos = service.findAll();
		return ResponseEntity.ok().body(todos);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Optional<Time>> findById(@PathVariable Long id){
		Optional<Time> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value= "/nome/{nomeTime}")
	public ResponseEntity <Optional<Time>> findByName(@PathVariable("nomeTime") String nome){
		Optional<Time> obj = service.findByNomeEqualsIgnoreCase(nome);
		return ResponseEntity.ok().body(obj);
	}
	

	
}
