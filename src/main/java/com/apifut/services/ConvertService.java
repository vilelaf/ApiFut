package com.apifut.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.apifut.DTO.JogadorDTO;
import com.apifut.DTO.TimeDTO;
import com.apifut.entities.Jogador;
import com.apifut.entities.Time;
import com.apifut.services.exceptions.ResourceNotFoundException;
import com.apifut.util.enums.PosicaoEnum;

@Service
public class ConvertService {

	public Jogador convertJogadorDTOtoEntity(JogadorDTO dto) {
		
		Jogador j = new Jogador();
		j.setId(dto.getId());
		j.setNome(dto.getNome());
		j.setNumero(dto.getNumero());
		j.setPosicao(PosicaoEnum.getEnum(dto.getPosicao()));
		j.setIdade(dto.getIdade());
		j.setNacionalidade(dto.getNacionalidade());
		j.setTime(dto.getTime());
		
		return j;
		
	}

	public JogadorDTO convertEntityToJogadorDTO(Jogador j) {
		
		JogadorDTO dto = new JogadorDTO();
		dto.setId(j.getId());
		dto.setNome(j.getNome());
		dto.setNumero(j.getNumero());
		dto.setPosicao(j.getPosicao().getValor());	
		dto.setIdade(j.getIdade());
		dto.setNacionalidade(j.getNacionalidade());
		dto.setTime(j.getTime());
		
		return dto;
		
	}
	
	public Time convertTimeDTOtoEntity(TimeDTO dto) {
	
		Time t = new Time();
		
		t.setId(dto.getId());
		t.setNome(dto.getNome());
		for(Jogador j : dto.getJogadores()) {
			j.setTime(t);
		}
		return t;
		
	}
	
	public TimeDTO convertEntityToTimeDTO(Time t) {
				
		TimeDTO dto = new TimeDTO();
		
		dto.setId(t.getId());
		dto.setFormacao(t.getFormacao());
		dto.setNome(t.getNome());
		dto.setJogadores(t.getJogadores());

		return dto;
	}
	
	public TimeDTO convertTimeObjToTimeDTO(Optional<Time> obj) {
		
		TimeDTO dto = new TimeDTO();
		
		try {
			dto.setId(obj.get().getId());
			dto.setNome(obj.get().getNome());
			dto.setFormacao(obj.get().getFormacao());
			dto.setJogadores(obj.get().getJogadores());
			return dto;
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(obj.get().getId());
		}
		
	}
	
	
}
