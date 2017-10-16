package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.implementation.IPizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
	}

	public void execute(Scanner question) {
		// Affiche la carte
		afficherAllPizzas();

	}

	@Override
	public String getLibelle() {
		return "\n 1. Lister les pizzas";
	}

}
