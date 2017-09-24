package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;

public abstract class OptionMenu {
	
	public abstract void execute(Scanner question);
	public abstract String getLibelle();
	protected PizzaDaompl dao;
	public OptionMenu(PizzaDaompl dao){
		this.dao = dao;
	}

}
