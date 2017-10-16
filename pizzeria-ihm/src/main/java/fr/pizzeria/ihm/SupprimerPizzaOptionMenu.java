package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizza.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzaOptionMenu.class);
	Pizza[] pizzas;

	public SupprimerPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}

	public void execute(Scanner question) throws DeletePizzaException {
		afficherAllPizzas();
		LOG.info("\nVeuillez choisir la pizza à supprimer \n(99 pour abandonner)");
		String codePizza = question.nextLine();
		if (("99").equals(codePizza)) {
			return;
		}
		if (codePizza.length() < 3) {
			throw new DeletePizzaException("Le code pizza doit être d'au moins 3 caractères");
		}
		dao.deletePizza(codePizza);

		LOG.debug("\nPizza " + codePizza + " supprimée");

	}

	@Override
	public String getLibelle() {
		return "\n 4. Supprimer une pizza";
	}

}
