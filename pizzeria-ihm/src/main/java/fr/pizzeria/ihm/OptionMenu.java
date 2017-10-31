package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import dao.implementation.IPizzaDao;
import fr.pizza.model.Pizza;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	@Autowired protected Logger LOG;
	public abstract void execute(Scanner scanner) throws StockageException;
	public abstract String getLibelle();
	@Autowired protected IPizzaDao dao;
	
	public void afficherAllPizzas(){
		for (Pizza i : dao.findAllPizzas()) {
			LOG.info(i.toString());
				
		}
	}
}
