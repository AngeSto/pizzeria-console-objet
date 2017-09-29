package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	

	Pizza[] pizzas;
	public AjouterPizzaOptionMenu (IPizzaDao dao) {
		super(dao);
	}
	
	
	
	public void execute(Scanner question) throws SavePizzaException, StockageException {
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
		String prixStr = question.nextLine();
		double prix = Double.parseDouble(prixStr);
		System.out.println("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
		String scategorie = question.nextLine();
		CategoriePizza returncategorie = CategoriePizza.sameLibelle(scategorie);
		 
		
		
		dao.saveNewPizza(code, nom, prix, returncategorie);
		
		System.out.println("\nPizza "+code+" ajoutée");
		
	}



	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 2. Ajouter une nouvelle pizza";
	}

}
