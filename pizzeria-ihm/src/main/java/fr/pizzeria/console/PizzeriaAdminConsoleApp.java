package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaDaompl;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		IPizzaDao dao = new PizzaDaompl();
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(dao);
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(dao);
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(dao);
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(dao);
		
		
		// TODO Auto-generated method stub	
		//Annonce la variable "choix" avant do while sinon erreur
		String choix = "";
		//Boucle do pour revenir au menu à chaque fois, seul moyen d'en sortir est d'écrire 99 (dans condition while), do while pour que la boucle s'effectue au moins une fois
		
		do {
			try{
			System.out.println("\n*****Pizzeria Administration*****"+lister.getLibelle()+ajouter.getLibelle()+modifier.getLibelle()+supprimer.getLibelle()+"\n 99. Sortir");
			Scanner question = new Scanner(System.in).useLocale(Locale.US);
			choix = question.nextLine();
			//Utilisation d'un switch pour eviter le cumul de if else, et pour avoir le default si on écrit autre chose que demandé
			switch (choix) {
			case "1": 
				lister.execute(question);
				break;
			case "2":
				ajouter.execute(question);
				
				break;
			case "3":
				modifier.execute(question);
				break;
			case "4":
				supprimer.execute(question);
				break;
			case "99":
				System.out.println("Aurevoir \u2639");// Comme écrit sur le TP

				break;

			default:
				System.out.println("Veuillez rentrer une valeur correct");
			}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
			
		} while (!("99").equals(choix));

	}

}
