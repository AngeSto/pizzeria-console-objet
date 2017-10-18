package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implementation.IPizzaDao;
import dao.jdbc.PizzaDaoJDBC;
import dao.jpa.PizzaDaoJPA;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.InitialiserPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) {
		
		IPizzaDao dao = new PizzaDaoJPA();
		Map<String, OptionMenu> optionMenus = new HashMap<>();
		optionMenus.put("1", new ListerPizzasOptionMenu(dao));
		optionMenus.put("2", new AjouterPizzaOptionMenu(dao));
		optionMenus.put("3", new ModifierPizzaOptionMenu(dao));
		optionMenus.put("4", new SupprimerPizzaOptionMenu(dao));
		optionMenus.put("5", new InitialiserPizzaOptionMenu(dao));
		// Annonce la variable "choix" avant do while sinon erreur
		String choix = "";
		// Boucle do pour revenir au menu à chaque fois, seul moyen d'en sortir
		// est d'écrire 99 (dans condition while), do while pour que la boucle
		// s'effectue au moins une fois
		do {
			try {
				LOG.info("\n*****Pizzeria Administration*****" + optionMenus.get("1").getLibelle() +optionMenus.get("2").getLibelle()
						+ optionMenus.get("3").getLibelle() + optionMenus.get("4").getLibelle() + optionMenus.get("5").getLibelle() + "\n 99. Sortir");
				Scanner question = new Scanner(System.in);
				question.useLocale(Locale.US);
				choix = question.nextLine();
				
				if(optionMenus.get(choix)!=null){
					optionMenus.get(choix).execute(question);
				}
				

			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}

		} while (!("99").equals(choix));
		LOG.info("Aurevoir \u2639");// Comme écrit sur le TP
	}

}
