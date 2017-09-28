package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaompl implements IPizzaDao {
	
	List<Pizza> listpizzas = new ArrayList<Pizza>();

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
		

		for (int i = 0; i < pizzas.length; i++){
			listpizzas.add(pizzas[i]);
		}
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return listpizzas;
	}

	@Override
	public boolean saveNewPizza(String code, String nom, Double prix, CategoriePizza returncategorie) {
		Pizza newpizza = new Pizza (code,nom,prix, returncategorie);
		listpizzas.add(newpizza);
			
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza, boolean trouve) {
		
		Iterator<Pizza> iterator = listpizzas.iterator();
		while (iterator.hasNext()){
			
			Pizza pizza = (Pizza) iterator.next();
			if(pizza.getCode().equals(codePizza)){
				trouve = true;
				iterator.remove();
			}
			
		}

		return false;
	}

	public boolean updatePizza(String codeAModifier, String code, String nom, Double prix, CategoriePizza returncategorie) {
		
		Iterator<Pizza> iterator = listpizzas.iterator();
		while (iterator.hasNext()){
			
			Pizza pizza = (Pizza) iterator.next();
			if(pizza.getCode().equals(codeAModifier)){
				pizza.setCode(code);
				pizza.setNom(nom);
				pizza.setPrix(prix);
				pizza.setCategorie(returncategorie);
				
			}
			
		}

		
		return false;
		
	}

}
