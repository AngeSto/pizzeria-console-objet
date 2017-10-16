package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(ModifierPizzaOptionMenu.class);
	public ModifierPizzaOptionMenu (IPizzaDao dao) {
		super(dao);
	}

	public void execute(Scanner question) throws StockageException {
		boolean trouve = false;
		afficherAllPizzas();
		LOG.info("\nVeuillez choisir la pizza à modifier \n(99 pour abandonner)");
		String codeAModifier = question.nextLine();
		if (("99").equals(codeAModifier)) {
			return;
		}
		//Cherche la pizza avec le code de référence entré, utilise getCode pour trouver la pizza référencée
		
		for (Pizza i : dao.findAllPizzas()) {
			if (i.getCode().equals(codeAModifier)) {
				trouve = true;
				LOG.info("Veuillez saisir le code de la pizza");
				String code = question.nextLine();
				if (code.length()<3){
					throw new UpdatePizzaException("Le code pizza doit être d'au moins 3 caractères");
				}
				LOG.info("Veuillez saisir le nom (sans espace svp) de la pizza");
				String nom = question.nextLine();
				LOG.info("Veuillez saisir le prix de la pizza");
				String prixStr = question.nextLine();
				double prix = Double.parseDouble(prixStr);
				LOG.info("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
				String scategorie = question.nextLine();
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
		return "\n 3. Mettre à jour une pizza";
	}

}
