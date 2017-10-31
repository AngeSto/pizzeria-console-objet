package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

@Controller
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	public void execute(Scanner scanner) throws StockageException {
		
		//Demande les informations pour la nouvelle pizza
		LOG.info("Veuillez saisir le code de la pizza");
		String code = scanner.next();
		if (code.length()<3){
			throw new SavePizzaException("Le code pizza doit être d'au moins 3 caractères");
		}
		LOG.info("Veuillez saisir le nom (sans espace svp) de la pizza");
		String nom = scanner.next();
		LOG.info("Veuillez saisir le prix de la pizza");
		String prixStr = scanner.next();
		double prix = Double.parseDouble(prixStr);
		LOG.info("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
		String scategorie = scanner.next();
		CategoriePizza returncategorie = CategoriePizza.sameLibelle(scategorie);
		 
		
		
		dao.saveNewPizza(code, nom, prix, returncategorie);
		
		LOG.debug("Pizza "+code+" ajoutée");
		
	}



	@Override
	public String getLibelle() {
		return "Ajouter une nouvelle pizza";
	}

}
