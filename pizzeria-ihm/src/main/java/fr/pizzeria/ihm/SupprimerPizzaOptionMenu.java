package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizza.model.Pizza;

@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {

	public void execute(Scanner scanner) throws DeletePizzaException {
		afficherAllPizzas();
		LOG.info("\nVeuillez choisir la pizza à supprimer \n(99 pour abandonner)");
		String codePizza = scanner.next();
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
		return "Supprimer une pizza";
	}

}
