package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizza.model.CategoriePizza;
import fr.pizza.model.Pizza;

public class PizzaDaompl implements IPizzaDao {

	public List<Pizza> listpizzas = new ArrayList<>();

	public PizzaDaompl() {
		// Création de la carte à pizza selon un tableau
		Pizza[] pizzas = new Pizza[8];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE);
		pizzas[3] = new Pizza("FRO", "La 4 Fromage", 12.00, CategoriePizza.SANS_VIANDE);
		pizzas[4] = new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE);
		pizzas[5] = new Pizza("SAV", "La Savoyarde", 13.00, CategoriePizza.VIANDE);
		pizzas[6] = new Pizza("ORI", "L'Orientale", 13.50, CategoriePizza.VIANDE);
		pizzas[7] = new Pizza("IND", "L'Indienne", 14.00, CategoriePizza.VIANDE);

		for (int i = 0; i < pizzas.length; i++) {
			listpizzas.add(pizzas[i]);
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {

		return listpizzas;
	}

	@Override
	public boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie) {
		Pizza newpizza = new Pizza(code, nom, prix, returncategorie);
		listpizzas.add(newpizza);

		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		boolean trouve = false;
		Iterator<Pizza> iterator = listpizzas.iterator();
		while (iterator.hasNext()) {

			Pizza pizza = iterator.next();
			if (pizza.getCode().equals(codePizza)) {
				trouve = true;
				iterator.remove();
			}

		}
		if (trouve == false) {
			throw new DeletePizzaException("Pizza à modifier inexistant, veuillez écrire une pizza existante");
		}
		return false;
	}

	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix,
			CategoriePizza returncategorie) throws UpdatePizzaException {

		Iterator<Pizza> iterator = listpizzas.iterator();
		boolean trouve = false;
		while (iterator.hasNext()) {
			Pizza pizza = iterator.next();
			if (pizza.getCode().equals(codeAModifier)) {
				trouve = true;
				pizza.setCode(code);
				pizza.setNom(nom);
				pizza.setPrix(prix);
				pizza.setCategorie(returncategorie);

			}

		}

		if (trouve == false) {
			throw new UpdatePizzaException("Pizza à modifier inexistant, veuillez écrire une pizza existante");
		}

		return false;

	}

}
