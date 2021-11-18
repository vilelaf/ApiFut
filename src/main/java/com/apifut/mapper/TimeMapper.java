package com.apifut.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.apifut.DTO.TimeDTO;
import com.apifut.entities.Time;

@Mapper
public interface TimeMapper {

	TimeMapper INSTANCE = Mappers.getMapper(TimeMapper.class);
	
	Time toModel(TimeDTO timeDTO);
	
	TimeDTO toDTO(Time time);
}
