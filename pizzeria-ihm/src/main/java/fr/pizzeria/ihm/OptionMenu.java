package fr.pizzeria.ihm;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.implementation.IPizzaDao;
import fr.pizza.model.Pizza;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	protected static final Logger LOG = LoggerFactory.getLogger(OptionMenu.class);
	public abstract void execute(Scanner question) throws StockageException;
	public abstract String getLibelle();
	protected IPizzaDao dao;
	public OptionMenu(IPizzaDao dao){
		this.dao = dao;
	}
	public void afficherAllPizzas(){
		for (Pizza i : dao.findAllPizzas()) {
			LOG.info(i.toString());
				
		}
	}
}
