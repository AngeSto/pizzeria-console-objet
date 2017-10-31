package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.StockageException;

@Controller
public class InitialiserPizzaOptionMenu extends OptionMenu{

	@Override
	public void execute(Scanner scanner) throws StockageException {
		
		dao.initiatePizza();
		
		LOG.debug("Tableau de pizza initialisé");
	}

	@Override
	public String getLibelle() {
		
		return "Initialiser le tableau de pizza";
	}

}
