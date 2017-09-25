package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	
	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
	}


	public void execute(Scanner question) {
		// TODO Auto-generated method stub
		//Affiche la carte
		for (Pizza i : dao.findAllPizzas()) {
				System.out.println(i);
			
			
		}

	}


	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 1. Lister les pizzas";
	}




}
