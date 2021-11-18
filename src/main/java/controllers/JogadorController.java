package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.apifut.mapper.JogadorMapper;
import com.apifut.services.ConvertService;
import com.apifut.services.JogadorService;

@RestController
@RequestMapping (value = "/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService service;
	
	private final JogadorMapper jogadorMapper = JogadorMapper.INSTANCE; // java.lang.ExceptionInInitializerError: null
	
	
	@GetMapping
	public ResponseEntity<List<Response<JogadorDTO>>> findAll(@Valid @RequestBody JogadorDTO dto, BindingResult r){
		List <Response<JogadorDTO>> response = new ArrayList();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.forEach(a -> a.getErrors().add(e.getDefaultMessage())));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		

		List<JogadorDTO> dtoList = service.findAll()
				.stream()
				.map(jogadorMapper::toDTO)
				.collect(Collectors.toList());
		for (JogadorDTO jdto : dtoList) {
			Response<JogadorDTO> d1 = new Response<JogadorDTO>();
			d1.setData(jdto);
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
		
		response.setData(jogadorMapper.toDTO(service.findById(id)));
		
		return ResponseEntity.ok().body(response);
		
	}

	@PostMapping
	public ResponseEntity <Response<JogadorDTO>> insertJogador(@Valid @RequestBody JogadorDTO dto, BindingResult r){
		
		Response <JogadorDTO> response = new Response<JogadorDTO>();
		
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}	
		
		Jogador j = service.save(jogadorMapper.toModel(dto));
		response.setData(jogadorMapper.toDTO(j));
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity <Response<JogadorDTO>> update(@PathVariable Long id, @Valid @RequestBody JogadorDTO dto, BindingResult r) {
		
		Response <JogadorDTO> response = new Response<JogadorDTO>();
		if (r.hasErrors()) {
			r.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		
		Jogador j = service.update(id, jogadorMapper.toModel(dto));
		
		response.setData(jogadorMapper.toDTO(j));

		return ResponseEntity.ok().body(response);
		
	}
	
	@DeleteMapping(value= "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	

}
