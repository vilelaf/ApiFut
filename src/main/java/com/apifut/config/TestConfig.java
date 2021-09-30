package com.apifut.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
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
		
		
		try {
			String enderecoTimes = "C:\\Users\\rhcp_\\Desktop\\Plan Times Big Six";
			
			File endereco = new File(enderecoTimes);
			File arquivos [] = endereco.listFiles();
			int i = 0;
		
			for (int j = arquivos.length; i < j; i++) {
				File escalacao = arquivos[i];
				BufferedReader br = new BufferedReader(new FileReader(escalacao));
				
				String line = br.readLine();
				Time time = new Time(null,line,"4-3-3");
				timeRepository.save(time);
				
				int count = 0;
				Set<Jogador> jogadores = new HashSet<Jogador>();
				line = br.readLine();
				while (line!= null) {
					if (count == 0) {
						line = br.readLine();
						System.out.println("Criando o time " + time.getNome() + ".");
					}
					
					String strings[] = line.split(",");
					Jogador j0 = new Jogador (null,strings[0],PosicaoEnum.getEnum(strings[1]),new BigDecimal(strings[2]),strings[3],Integer.parseInt(strings[4]));
					j0.setTime(time);
					jogadorRepository.save(j0);
					jogadores.add(j0);
					
					count++;
					line = br.readLine();
				}
			}	
		} 
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}	
}
		
