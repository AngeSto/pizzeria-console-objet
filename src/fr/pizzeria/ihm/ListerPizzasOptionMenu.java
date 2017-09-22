package fr.pizzeria.ihm;

import java.util.Scanner;

import dao.PizzaDaompl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {

	

	public ListerPizzasOptionMenu(PizzaDaompl dao) {
		this.dao = dao;
	}

	public void execute(Scanner question) {
		// TODO Auto-generated method stub
		//Affiche la carte
		for (Pizza i : dao.findAllPizzas()) {
			if (i != null){
				System.out.println(i);
			}
			
		}

	}




}
