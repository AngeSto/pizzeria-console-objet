package dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaompl implements IPizzaDao {
	
	Pizza[] pizzas;

	public PizzaDaompl() {
		// Création de la carte à pizza selon un tableau
		pizzas = new Pizza[50];
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
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = new Pizza(code, nom, prix);
				break;
			}

		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// Cherche la pizza référencée avec getCode, puis crée un tableau de
		// longueur -1
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] != null && pizzas[i].getCode().equals(codePizza)) {
				pizzas[i] = null;
			}
		}
		return false;
	}

	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix) {
		for (Pizza i : pizzas) {
			if (i != null && i.getCode().equals(codeAModifier)) {
				i.setCode(code);
				i.setNom(nom);
				i.setPrix(prix);
				
			}
		}
		return false;
		
	}

}
