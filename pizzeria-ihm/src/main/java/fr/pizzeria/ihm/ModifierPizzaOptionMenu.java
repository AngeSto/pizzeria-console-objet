package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

@Controller
public class ModifierPizzaOptionMenu extends OptionMenu {

	public void execute(Scanner scanner) throws StockageException {
		boolean trouve = false;
		afficherAllPizzas();
		LOG.info("\nVeuillez choisir la pizza à modifier \n(99 pour abandonner)");
		String codeAModifier = scanner.nextLine();
		if (("99").equals(codeAModifier)) {
			return;
		}
		//Cherche la pizza avec le code de référence entré, utilise getCode pour trouver la pizza référencée
		
		for (Pizza i : dao.findAllPizzas()) {
			if (i.getCode().equals(codeAModifier)) {
				trouve = true;
				LOG.info("Veuillez saisir le code de la pizza");
				String code = scanner.next();
				if (code.length()<3){
					throw new UpdatePizzaException("Le code pizza doit être d'au moins 3 caractères");
				}
				LOG.info("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = scanner.next();
				LOG.info("Veuillez saisir le prix de la pizza");
				String prixStr = scanner.next();
				double prix = Double.parseDouble(prixStr);
				LOG.info("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
				String scategorie = scanner.next();
				CategoriePizza returncategorie = CategoriePizza.sameLibelle(scategorie);
				dao.updatePizza(codeAModifier, code, nom, prix, returncategorie);
				
				
				LOG.debug("\nPizza "+codeAModifier+" modifiée");
			}
				
			
		}
		if (trouve == false){
			throw new UpdatePizzaException("Pizza à modifier inexistant, veuillez écrire une pizza existante");
		}
	}

	@Override
	public String getLibelle() {
		return "Mettre à jour une pizza";
	}

}
