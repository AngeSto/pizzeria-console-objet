package fr.pizzeria.console;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dao", "fr.pizzeria.ihm", "fr.pizzeria.console"})
public class Config {
	
	
	//Pour avoir qu'une seule instance de scanner partout ,on peut l'appeler partout car @Bean présent
	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	@Bean
	public Logger log(){
		return LoggerFactory.getLogger("Console");
	}
}
