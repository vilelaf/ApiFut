package com.apifut.services;

import org.springframework.stereotype.Service;

import com.apifut.DTO.JogadorDTO;
import com.apifut.DTO.TimeDTO;
import com.apifut.entities.Jogador;
import com.apifut.entities.Time;
import com.apifut.util.enums.PosicaoEnum;

@Service
public class JogadorConvertService {

	public Jogador convertJogadorDTOtoEntity(JogadorDTO dto) {
		
		Jogador j = new Jogador();
		j.setId(dto.getId());
		j.setNome(dto.getNome());
		j.setNumero(dto.getNumero());
		j.setPosicao(PosicaoEnum.getEnum(dto.getPosicao()));
		j.setTime(dto.getTime());
		
		return j;
		
	}

	public JogadorDTO convertEntityToJogadorDTO(Jogador j) {
		
		JogadorDTO dto = new JogadorDTO();
		dto.setId(j.getId());
		dto.setNome(j.getNome());
		dto.setNumero(j.getNumero());
		dto.setPosicao(j.getPosicao().getValor());		
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
	
	public TimeDTO convertTimeEntityToJogadorDTO(Time t) {
				
		TimeDTO dto = new TimeDTO();
		
		dto.setId(t.getId());
		dto.setFormacao(t.getFormacao());
		dto.setJogadores(t.getJogadores());

		return dto;
	}
}
