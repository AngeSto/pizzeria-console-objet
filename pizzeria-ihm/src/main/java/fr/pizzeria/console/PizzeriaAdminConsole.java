package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;
import dao.jpa.PizzaDaoJPA;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.InitialiserPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

@Controller
public class PizzeriaAdminConsole {
	private Map<Integer, OptionMenu> optionMenus = new HashMap<>();
	@Autowired private AnnotationConfigApplicationContext context;
	@Autowired private Scanner scanner;
	@Autowired private Logger LOG;
	
	@PostConstruct
	public void init(){
		Map<String, OptionMenu> rechercheOption = context.getBeansOfType(OptionMenu.class);
		AtomicInteger increment = new AtomicInteger();
		rechercheOption.forEach((id, option)->optionMenus.put(increment.incrementAndGet(), option));
	}
	
	public void demarrer() {
		
		// Annonce la variable "choix" avant do while sinon erreur
		Integer choix = null;
		// Boucle do pour revenir au menu à chaque fois, seul moyen d'en sortir
		// est d'écrire 99 (dans condition while), do while pour que la boucle
		// s'effectue au moins une fois
		do {
			try {
				LOG.info("\n*****Pizzeria Administration*****");
				optionMenus.forEach((cle, valeur)->LOG.info(cle+". "+valeur.getLibelle()));
				LOG.info("99. Sortir");
				
				scanner.useLocale(Locale.US);
				choix = scanner.nextInt();
				
				if(optionMenus.get(choix)!=null){
					optionMenus.get(choix).execute(scanner);
				}
				
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}

		} while (choix!=99);
		LOG.info("Aurevoir \u2639");// Comme écrit sur le TP
		scanner.close();
		context.close();
	}

}
