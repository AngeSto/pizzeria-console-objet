package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu (PizzaDaompl dao) {
		this.dao = dao;
	}

	public void execute(Scanner question) {
		// TODO Auto-generated method stub
		
		for (Pizza i : dao.findAllPizzas()) {
			if (i != null){
				System.out.println(i);
			}
			
		}
		System.out.println("\nVeuillez choisir la pizza à modifier \n(99 pour abandonner)");
		String codeAModifier = question.nextLine();
		if (codeAModifier.equals("99")) {
			return;
		}
		//Cherche la pizza avec le code de référence entré, utilise getCode pour trouver la pizza référencée

		for (Pizza i : dao.findAllPizzas()) {
			if (i.getCode().equals(codeAModifier)) {
				System.out.println("Veuillez saisir le code de la pizza");
				String code = question.nextLine();
				System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = question.nextLine();
				System.out.println("Veuillez saisir le prix de la pizza (utilisez une virgule pour les centimes)");
				Double prix = question.nextDouble();
				
				dao.updatePizza(codeAModifier, code, nom, prix);
				
				
				System.out.println("\nListe des pizzas modifier");
			}
		}
	}

}
