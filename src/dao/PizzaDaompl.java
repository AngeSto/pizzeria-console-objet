package dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaompl implements IPizzaDao {
	
	Pizza[] pizzas;

	public PizzaDaompl() {
		// Création de la carte à pizza selon un tableau
		pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 Fromage", 12.00);
		pizzas[4] = new Pizza("CAN", "La Cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La Savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'Indienne", 14.00);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(String code, String nom, Double prix) {
		Pizza[] newpizzas = new Pizza[pizzas.length + 1];
		 	//Recopie les valeurs de l'ancien tableau dans le nouveau
		 	for (int i = 0; i < pizzas.length; i++) {
		 		newpizzas[i] = pizzas[i];
		 	}
		 	//Ajout de la nouvelle pizza puis reviens aligne l'ancien tableau sur le nouveau
		 	newpizzas[newpizzas.length - 1] = new Pizza(code, nom, prix);
		 	pizzas = newpizzas;
			
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// Cherche la pizza référencée avec getCode, puis crée un tableau de
		// longueur -1
		for (int i = 0; i < pizzas.length; i++) {
			 					if (pizzas[i].getCode().equals(codePizza)) {
			 						Pizza[] jpizzas = new Pizza[pizzas.length - 1];
			 						for (int j = 0; j < pizzas.length-1; j++) { // L'idée ici est de décaler les pizzas en dessous de la pizza séléctionner de 1 vers le haut du tableau
			 							if (i > j) { // Pour les pizzas en dessous de la pizza sélectionnée
			 								jpizzas[j] = pizzas[j];
			 								jpizzas[j] = pizzas[j];
			 								jpizzas[j] = pizzas[j];
			 							} else { // Pour la pizza séléctionnée et les pizzas au dessus
			 									jpizzas[j] = pizzas[j + 1];
			 									jpizzas[j] = pizzas[j + 1];
			 									jpizzas[j] = pizzas[j + 1];
			 							}
			 
			 						}
			 						pizzas = jpizzas;
			 						
			 					}
			 				}
		return false;
	}

	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix) {
		for (Pizza i : pizzas) {
			if (i.getCode().equals(codeAModifier)) {
				i.setCode(code);
				i.setNom(nom);
				i.setPrix(prix);
				
			}
		}
		return false;
		
	}

}
