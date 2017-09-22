package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	Pizza[] pizzas;
	public SupprimerPizzaOptionMenu (PizzaDaompl dao) {
		this.dao = dao;
	}
	
	public void execute(Scanner question) {
		// TODO Auto-generated method stub
		
		for (Pizza i : dao.findAllPizzas()) {
			if (i != null){
				System.out.println(i);
			}
			
		}
		System.out.println("\nVeuillez choisir la pizza à supprimer \n(99 pour abandonner)");
		String codePizza = question.nextLine();
		if (codePizza.equals("99")) {
			return;
		}

		dao.deletePizza(codePizza);
	}

}
