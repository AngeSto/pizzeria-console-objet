package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaOptionMenu.class);

	Pizza[] pizzas;
	public AjouterPizzaOptionMenu (IPizzaDao dao) {
		super(dao);
	}
	
	
	
	public void execute(Scanner question) throws StockageException {
		
		//Demande les informations pour la nouvelle pizza
		LOG.info("Veuillez saisir le code de la pizza");
		String code = question.nextLine();
		if (code.length()<3){
			throw new SavePizzaException("Le code pizza doit être d'au moins 3 caractères");
		}
		LOG.info("Veuillez saisir le nom (sans espace svp) de la pizza");
		String nom = question.nextLine();
		LOG.info("Veuillez saisir le prix de la pizza");
		String prixStr = question.nextLine();
		double prix = Double.parseDouble(prixStr);
		LOG.info("Veuillez choisir une catégorie (Viande, Sans Viande ou Poisson)");
		String scategorie = question.nextLine();
		CategoriePizza returncategorie = CategoriePizza.sameLibelle(scategorie);
		 
		
		
		dao.saveNewPizza(code, nom, prix, returncategorie);
		
		LOG.debug("Pizza "+code+" ajoutée");
		
	}



	@Override
	public String getLibelle() {
		return "\n 2. Ajouter une nouvelle pizza";
	}

}
