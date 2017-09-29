package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu (IPizzaDao dao) {
		super(dao);
	}

	public void execute(Scanner question) throws UpdatePizzaException, StockageException {
		// TODO Auto-generated method stub
		boolean trouve = false;
		for (Pizza i : dao.findAllPizzas()) {
			System.out.println(i);
				
		}
		System.out.println("\nVeuillez choisir la pizza à modifier \n(99 pour abandonner)");
		String codeAModifier = question.nextLine();
		if (("99").equals(codeAModifier)) {
			return;
		}
		//Cherche la pizza avec le code de référence entré, utilise getCode pour trouver la pizza référencée
		
		for (Pizza i : dao.findAllPizzas()) {
			if (i.getCode().equals(codeAModifier)) {
				trouve = true;
				System.out.println("Veuillez saisir le code de la pizza");
				String code = question.nextLine();
				if (code.length()<3){
					throw new UpdatePizzaException("Le code pizza doit être d'au moins 3 caractères");
				}
				System.out.println("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = question.nextLine();
				System.out.println("Veuillez saisir le prix de la pizza");
				String prixStr = question.nextLine();
				double prix = Double.parseDouble(prixStr);
				System.out.println("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
				String scategorie = question.nextLine();
				CategoriePizza returncategorie = CategoriePizza.sameLibelle(scategorie);
				dao.updatePizza(codeAModifier, code, nom, prix, returncategorie);
				
				
				System.out.println("\nPizza "+codeAModifier+" modifiée");
			}
				
			
		}
		if (trouve == false){
			throw new UpdatePizzaException("Pizza à modifier inexistant, veuillez écrire une pizza existante");
		}
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 3. Mettre à jour une pizza";
	}

}
