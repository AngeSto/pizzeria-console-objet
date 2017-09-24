package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	
	public abstract void execute(Scanner question) throws StockageException;
	public abstract String getLibelle();
	protected PizzaDaompl dao;
	public OptionMenu(PizzaDaompl dao){
		this.dao = dao;
	}

}
