package com.apifut.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apifut.DTO.JogadorDTO;
import com.apifut.DTO.TimeDTO;
import com.apifut.entities.Response;
import com.apifut.entities.Time;
import com.apifut.services.ConvertService;
import com.apifut.services.TimeService;

@RestController
@RequestMapping (value = "/times")
public class TimeResource {

	@Autowired
	private TimeService service;
	@Autowired
	private ConvertService c;

	@GetMapping
	public ResponseEntity<List<Response<TimeDTO>>> findAll(@Valid @RequestBody TimeDTO dto, BindingResult r){
		List <Response<TimeDTO>> response = new ArrayList();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.forEach(a -> a.getErrors().add(e.getDefaultMessage())));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		List <Time> list = service.findAll();
		for (Time t : list) {
			Response<TimeDTO> d1 = new Response<TimeDTO>(); 
			dto = c.convertEntityToTimeDTO(t);
			d1.setData(dto);
			response.add(d1);
		}
		return ResponseEntity.ok().body(response);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity <Response<TimeDTO>> findById (@PathVariable Long id, @Valid @RequestBody TimeDTO dto, BindingResult r){
		
		Response<TimeDTO> response = new Response<TimeDTO>();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		Time t = service.findById(id);
		dto = c.convertEntityToTimeDTO(t);
		response.setData(dto);
		
		return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping(value= "/nome/{nomeTime}")
	public ResponseEntity <Optional<Time>> findByName(@PathVariable("nomeTime") String nome){
		Optional<Time> obj = service.findByNomeEqualsIgnoreCase(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PutMapping(value = "/limparJogadores/{nomeTime}")
	public ResponseEntity <Response<TimeDTO>> updateDeletingJogadores(@PathVariable("nomeTime") String nomeTime, BindingResult r){
		
		Response<TimeDTO> response = new Response<TimeDTO>();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		Optional<Time> obj = service.findByNomeEqualsIgnoreCase(nomeTime);
		
		obj.get().getJogadores().clear();
		
		TimeDTO timeDTO = c.convertTimeObjToTimeDTO(obj);
		
		Time t = service.updateByName(nomeTime, c.convertTimeDTOtoEntity(timeDTO));
		
		response.setData(c.convertEntityToTimeDTO(t));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	
	

	
}
