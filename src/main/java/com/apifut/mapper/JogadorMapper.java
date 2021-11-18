package com.apifut.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.apifut.DTO.JogadorDTO;
import com.apifut.entities.Jogador;

@Mapper
public interface JogadorMapper {

	JogadorMapper INSTANCE = Mappers.getMapper(JogadorMapper.class);
	
	@Mapping(target = "posicao", source = "posicao")
	Jogador toModel(JogadorDTO jogadorDTO);
	
	@Mapping(target = "posicao", source = "posicao")
	JogadorDTO toDTO(Jogador jogador);
	
	
}
