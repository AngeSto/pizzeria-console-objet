package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu (PizzaDaompl dao) {
		super(dao);
	}

	public void execute(Scanner question) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		
		for (Pizza i : dao.findAllPizzas()) {
			System.out.println(i);
				
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
				if (code.length()<3){
					throw new UpdatePizzaException("Le code pizza doit être d'au moins 3 caractères");
				}
				System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = question.nextLine();
				System.out.println("Veuillez saisir le prix de la pizza");
				Double prix = question.nextDouble();
				
				dao.updatePizza(codeAModifier, code, nom, prix);
				
				
				System.out.println("\nPizza "+codeAModifier+" modifiée");
			} else {throw new UpdatePizzaException("Veuillez écrire un code pizza existant");
				
			}
		}
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 3. Mettre à jour une pizza";
	}

}