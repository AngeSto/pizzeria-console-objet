package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	Pizza[] pizzas;
	public SupprimerPizzaOptionMenu (PizzaDaompl dao) {
		super(dao);
	}
	
	public void execute(Scanner question) throws DeletePizzaException {
		// TODO Auto-generated method stub
		
		for (Pizza i : dao.findAllPizzas()) {
			System.out.println(i);
			
		}
		System.out.println("\nVeuillez choisir la pizza à supprimer \n(99 pour abandonner)");
		String codePizza = question.nextLine();
		if (codePizza.equals("99")) {
			return;
		}
		if (codePizza.length()<3){
			throw new DeletePizzaException("Le code pizza doit être d'au moins 3 caractères");
		}
		dao.deletePizza(codePizza);
		System.out.println("\nPizza "+codePizza+" supprimée");
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "\n 4. Supprimer une pizza";
	}

}
