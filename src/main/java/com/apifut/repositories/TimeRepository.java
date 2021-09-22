package com.apifut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apifut.entities.Time;

public interface TimeRepository extends JpaRepository<Time,Long>{

	Optional<Time> findByNomeEquals(String nome);
	
	Optional<Time> findByNomeEqualsIgnoreCase(String nome);
	
}
