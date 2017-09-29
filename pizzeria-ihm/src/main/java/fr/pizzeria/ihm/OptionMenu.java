package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	
	public abstract void execute(Scanner question) throws StockageException;
	public abstract String getLibelle();
	protected IPizzaDao dao;
	public OptionMenu(IPizzaDao dao){
		this.dao = dao;
	}

}
