package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;

public abstract class OptionMenu {
	
	public abstract void execute(Scanner question);
	protected PizzaDaompl dao;

}
