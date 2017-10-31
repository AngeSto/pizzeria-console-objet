package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import dao.implementation.IPizzaDao;

@Controller
public class ListerPizzasOptionMenu extends OptionMenu {


	public void execute(Scanner scanner) {
		// Affiche la carte
		afficherAllPizzas();

	}

	@Override
	public String getLibelle() {
		return "Lister les pizzas";
	}

}
