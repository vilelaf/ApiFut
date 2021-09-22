package com.apifut.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apifut.entities.Jogador;
import com.apifut.entities.Time;
import com.apifut.repositories.JogadorRepository;
import com.apifut.repositories.TimeRepository;
import com.apifut.util.enums.PosicaoEnum;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private TimeRepository timeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Jogador j0 = new Jogador (null,"Cruyff", PosicaoEnum.MEI, 14);
		Jogador j1 = new Jogador (null,"Marques", PosicaoEnum.ZAG, 25);
		Jogador j2 = new Jogador (null,"Rivaldo", PosicaoEnum.MEI, 2);
		Jogador j3 = new Jogador (null,"Valdez", PosicaoEnum.GOL, 1);
		Jogador j4 = new Jogador (null,"Iniesta", PosicaoEnum.MEI, 8);
		Jogador j5 = new Jogador (null,"Romário", PosicaoEnum.ATA, 11);
		Jogador j6 = new Jogador (null,"Messi", PosicaoEnum.ATA, 10);
		Jogador j7 = new Jogador (null,"Giovanni", PosicaoEnum.ATA, 90);
		Jogador j8 = new Jogador (null,"Puyol", PosicaoEnum.ZAG, 4);
		Jogador j9 = new Jogador (null,"Milito", PosicaoEnum.ZAG, 12);
		
		Jogador j10 = new Jogador (null,"Etoo", PosicaoEnum.ATA, 9);
		Jogador j11 = new Jogador (null,"Ter Stegen", PosicaoEnum.GOL, 50);
		Jogador j12 = new Jogador (null,"Belleti", PosicaoEnum.ZAG, 14);
		Jogador j13 = new Jogador (null,"Dani Alves", PosicaoEnum.ZAG,  22);
		Jogador j14 = new Jogador (null,"Ronaldinho", PosicaoEnum.MEI, 80);
		
		
		
		
		jogadorRepository.saveAll(Arrays.asList(j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14));
		
		Set<Jogador>jogadores1 = new HashSet();
		Set<Jogador>jogadores2 = new HashSet();
		jogadores1.addAll(Arrays.asList(j1,j2,j3,j4,j5,j6,j7));
		jogadores2.addAll(Arrays.asList(j8,j9,j10,j11,j12,j13,j14));

	
		Time t1 = new Time (null, "Barça 1", "4-3-3");
		Time t2 = new Time (null, "Barça 2", "3-5-2");

		jogadores1.forEach(j -> j.setTime(t1));
		jogadores2.forEach(j -> j.setTime(t2));
		timeRepository.save(t1);
		timeRepository.save(t2);
		
		jogadorRepository.saveAll(Arrays.asList(j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14));
		
		
	}
	
	
	
	
}
