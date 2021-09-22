package com.apifut.resources;

import java.net.http.HttpResponse.ResponseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apifut.DTO.JogadorDTO;
import com.apifut.entities.Jogador;
import com.apifut.entities.Response;
import com.apifut.entities.Time;

import com.apifut.services.JogadorConvertService;
import com.apifut.services.JogadorService;

@RestController
@RequestMapping (value = "/jogadores")
public class JogadorResource {

	@Autowired
	private JogadorConvertService c; 
	@Autowired
	private JogadorService service;
	
	
	@GetMapping
	public ResponseEntity<List<Response<JogadorDTO>>> findAll(@Valid @RequestBody JogadorDTO dto, BindingResult r){
		List <Response<JogadorDTO>> response = new ArrayList();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.forEach(a -> a.getErrors().add(e.getDefaultMessage())));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
		List <Jogador> list = service.findAll();
		for(int i = 0; i< list.size(); i++) {
			Response<JogadorDTO> d1 = new Response<JogadorDTO>();
			dto = c.convertEntityToJogadorDTO(list.get(i));
			d1.setData(dto);
			response.add(d1);
		}

		return ResponseEntity.ok().body(response);
		
	}

	@GetMapping(value= "/{id}")
	public ResponseEntity <Response<JogadorDTO>> findById(@PathVariable Long id, BindingResult r){
		
		Response <JogadorDTO> response = new Response<JogadorDTO>();
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		response.setData(c.convertEntityToJogadorDTO(service.findById(id)));
		
		return ResponseEntity.ok().body(response);
		
	}

	@PostMapping
	public ResponseEntity <Response<JogadorDTO>> insertJogador(@Valid @RequestBody JogadorDTO dto, BindingResult r){
		
		Response <JogadorDTO> response = new Response<JogadorDTO>();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}	
		
		Jogador j = service.save(c.convertJogadorDTOtoEntity(dto));
		response.setData(c.convertEntityToJogadorDTO(j));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity <Response<JogadorDTO>> update(@PathVariable Long id, @Valid @RequestBody JogadorDTO dto, BindingResult r) {
		
		Response <JogadorDTO> response = new Response<JogadorDTO>();
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		Jogador j = new Jogador();
		
		j = service.update(id, c.convertJogadorDTOtoEntity(dto));
		
		response.setData(c.convertEntityToJogadorDTO(j));
		
		
		return ResponseEntity.ok().body(response);
		
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	

}
