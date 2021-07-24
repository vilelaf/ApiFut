package com.apifut.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apifut.entities.Jogador;
import com.apifut.util.enums.PosicaoEnum;

@RestController
@RequestMapping (value = "/jogadores")
public class JogadorResource {

	@GetMapping
	public ResponseEntity<Jogador> findAll(){
		Jogador j = new Jogador (1L,"Patchuca", PosicaoEnum.FIXO, null , 3);

		return ResponseEntity.ok().body(j);
		
	}
	
	
	
}
