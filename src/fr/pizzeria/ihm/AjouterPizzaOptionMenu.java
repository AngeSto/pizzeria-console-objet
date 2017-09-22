package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	

	Pizza[] pizzas;
	public AjouterPizzaOptionMenu (PizzaDaompl dao) {
		this.dao = dao;
	}
	
	
	public void execute(Scanner question) {
		// TODO Auto-generated method stub
		
		//Demande les informations pour la nouvelle pizza
		System.out.println("Veuillez saisir le code de la pizza");
		String code = question.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
		String nom = question.nextLine();
		System.out.println("Veuillez saisir le prix de la pizza (utilisez une virgule pour les centimes)");
		double prix = question.nextDouble();
		
		dao.saveNewPizza(code, nom, prix);
		
	}

}
