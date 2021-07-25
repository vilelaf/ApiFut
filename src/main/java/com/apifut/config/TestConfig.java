package com.apifut.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apifut.entities.Jogador;
import com.apifut.repositories.JogadorRepository;
import com.apifut.util.enums.PosicaoEnum;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Override
	public void run(String... args) throws Exception {
		Jogador j1 = new Jogador (null,"Carlinho", PosicaoEnum.ALA_DIR, null, 10);
		Jogador j2 = new Jogador (null,"Tuta", PosicaoEnum.PIVO, null, 9);
		
		jogadorRepository.saveAll(Arrays.asList(j1,j2));
		
	}
	
}
