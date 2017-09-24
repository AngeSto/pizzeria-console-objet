package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	

	Pizza[] pizzas;
	public AjouterPizzaOptionMenu (PizzaDaompl dao) {
		super(dao);
	}
	
	
	
	public void execute(Scanner question) throws SavePizzaException {
		// TODO Auto-generated method stub
		
		//Demande les informations pour la nouvelle pizza
		System.out.println("Veuillez saisir le code de la pizza");
		String code = question.nextLine();
		if (code.length()<3){
			throw new SavePizzaException("Le code pizza doit être d'au moins 3 caractères");
		}
		System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
		String nom = question.nextLine();
		System.out.println("Veuillez saisir le prix de la pizza");
		double prix = question.nextDouble();
		
		dao.saveNewPizza(code, nom, prix);
		
		System.out.println("\nPizza "+code+" ajoutée");
		
	}



	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 2. Ajouter une nouvelle pizza";
	}

}
