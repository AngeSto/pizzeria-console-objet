package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implementation.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class InitialiserPizzaOptionMenu extends OptionMenu{
	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzaOptionMenu.class);
	public InitialiserPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
	}

	@Override
	public void execute(Scanner question) throws StockageException {
		
		dao.initiatePizza();
		
		LOG.debug("Tableau de pizza initialisé");
	}

	@Override
	public String getLibelle() {
		
		return "\n 5. Initialiser le tableau de pizza";
	}

}
